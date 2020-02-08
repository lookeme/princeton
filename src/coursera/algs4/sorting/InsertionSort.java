package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class InsertionSort {
	private int[] arr = new int[] { 10, 2, 0, 5 ,7};
	
	public void sort() {
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
				swap(j, j-1);
			}
		}
	}
	
	public void sort2(){
	

	}
	
	void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
    arr[j] = temp;
	}
	
	public static void main(String... args) {
		
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort();
		StdOut.println(Arrays.toString(insertionSort.arr));
		
		
	}
	
}
