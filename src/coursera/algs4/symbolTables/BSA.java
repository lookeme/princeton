package coursera.algs4.symbolTables;

import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class BSA {
	public static void main(String... args) {
		int[] arr = {3,-7, 5, 9, 4, 89, 0, 7, 5};
		Arrays.sort(arr);
		
		StdOut.println(Arrays.toString(arr));
		
		int inx = finaElement(arr, -7);
		StdOut.println(inx);
		
	}
	
	public static int finaElement(int[] arr, int el) {
		int size = arr.length;
		
		if (size == 0) throw new IllegalArgumentException();
		return binarySearch(0, size - 1, arr, el);
	}
	
	private static int binarySearch(int start, int end, int arr[], int el) {
		
		if (start > end) return start;
		
		int mid = start + (end - start) / 2;
		
		if (el > arr[mid])  return binarySearch( mid+1, end, arr, el);
		
		else if (el < arr[mid]) return binarySearch(start, mid, arr, el);
		
		else return mid;
		
	}
}
