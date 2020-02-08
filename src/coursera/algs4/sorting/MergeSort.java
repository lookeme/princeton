package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class MergeSort {
	private static Integer[] aux;
	private int cnt;
	

	
	private void sort(Integer[] arr) {
		aux = new Integer[arr.length];
		sort(arr,0, arr.length-1);
	
	}
	
	private void sort(Integer[] arr, int lo, int hi) {
		if (hi <= lo) return;
		int mid  = lo + (hi-lo) / 2;
		
		sort(arr, lo, mid);
		sort(arr, mid + 1, hi);
		merge(arr, lo, mid, hi);
		
	}
	
	private void merge(Integer[] arr, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		
		
		for(int k = lo; k <= hi; k++ ) aux[k] = arr[k];
		
		
		for(int k = lo; k <= hi; k++) {
			if (i > mid)        					arr[k] = aux[j++];
			else if (j > hi)    					arr[k] = aux[i++];
			else if (aux[i] > aux[j])     arr[k] = aux[j++];
			else                          arr[k] = aux[i++];
		}
	}
	
	public static void main(String... args) {
		Integer[]  arr = new Integer[]{ 5, 7, 8, 9, 30, 66, 99 , 33, 40 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr);
		StdOut.println(Arrays.toString(arr));
		
	}
}
