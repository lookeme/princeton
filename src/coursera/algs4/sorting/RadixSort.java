package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class RadixSort {
	public static void radixSort(int[] input, int radix, int width) {
		for (int i = 0; i < width; i++) {
			radixSingleSort(input, i, radix);
		}
	}
	
	public static void radixSingleSort(int[] input, int position, int radix) {
		
		int numItems = input.length;
		int[] countArray = new int[radix];
		
		for (int value: input) {
			StdOut.println("val = " + value + " postion -> " +position + "  "+ getDigit(position, value, radix));
			countArray[getDigit(position, value, radix)]++;
		}
		StdOut.println(Arrays.toString(countArray));
		// Adjust the count array
		for (int j = 1; j < radix; j++) {
			countArray[j] += countArray[j - 1];
		}
		StdOut.println(Arrays.toString(countArray));
		
		int[] temp = new int[numItems];
		
		for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
			temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
		}
		
		System.arraycopy(temp, 0, input, 0, temp.length);
		StdOut.println(Arrays.toString(input));
	}
	
	
	public static int getDigit(int position, int value, int radix) {
		return value / (int) Math.pow(radix, position) % radix;
	}

	
	
	public static void main(String... args) {
		int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };
		RadixSort radixSort = new RadixSort();
		radixSort.radixSort(radixArray, 10, 4);
		
		StdOut.println(Arrays.toString(radixArray));
		
	}
}
