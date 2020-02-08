package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class QuickSort {
	
	
	public void  quickSort(int[] input) {
		 quickSort(input, 0, input.length - 1);
	}
	
	

	
	private  int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		int pivot = a[lo];
		while (true) {
			
			while (a[++i] < pivot) if (i == hi) break;
			while (pivot < a[--j]) if (j == lo) break;
			
			if(i >= j) break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}
	

	
	public void quickSort(int[] a, int lo, int hi) {
		if (hi <= lo) return;
		
		int pivot = partition(a, lo, hi);
		quickSort(a, lo, pivot - 1);
		quickSort(a, pivot + 1, hi);
	
		

	}
	
	void swap(int[] arr, int lo, int j) {
		int temp = arr[lo];
		arr[lo] = arr[j];
		arr[j] = temp;
	}
	
	
	
	
	
	
	
	
	public static void main(String... args) {
		int[] arr = new int[]{ 5, 7, 8, 9, 30, 66, 99 , 33, 40 };
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(arr);
		StdOut.println(Arrays.toString(arr));
		StdOut.println(7/2);
		
	}
}
