package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class BubbleSort {
	int[] arr = {3,6,-7,-4,10,11,30,50};
	
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sort() {
		int size = arr.length;
		for(int sortedPart = size -1; sortedPart > 0; sortedPart--) {
			for (int i = 0; i < sortedPart; i++) {
				if (arr[i] > arr[i+1]) swap(i, i+1);
			}
		}
	}
	public static void main(String... args) {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort();
		StdOut.println(Arrays.toString(bubbleSort.arr));
	}
}
