package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class SelectionSort  {
	
	private int[] arr = new int[] { 10, 2, 0, 5 ,7};


	
	public static void main(String... args) {
		
		SelectionSort insertionSort = new SelectionSort();
		insertionSort.sort();
		StdOut.println(Arrays.toString(insertionSort.arr));
	
		
	}
	
	public void sort() {
		int size = arr.length;
		for(int sortedPart = size - 1; sortedPart > 0; sortedPart--) {
			int max = 0;
			for (int i = 0; i <= sortedPart; i++) {
				if (arr[max] < arr[i]) max = i;
			}
			swap(sortedPart, max);
		}
		

	}
	void swap(int i, int j) {
		if (i == j) return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
