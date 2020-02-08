package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class ShellSort {
	
	private int[] arr = new int[] { 10, 2, 0, 5 ,7, 6, 10, 20 };
	
	void sort() {
		int size = arr.length;
		int gap = 1;
		while (gap <= size /3) gap = 3* gap + 1;
		while (gap > 0) {
			for(int i = gap; i < size; i++) {
				for (int j = i; j > 0 && arr[j] < arr[j-gap]; j -= gap) {
					swap(j, j-gap);
				}
			}
			gap = gap / 3;
		}
	}
	
	
	void sort2() {
		int size = arr.length;
		for (int gap = size / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < size; i++) {
				int newElm = arr[i];
				
				int j = i;
				
				while (j >= gap && arr[j-1] > newElm) {
					arr[j] = arr[j-gap];
					j -= gap;
				}
				arr[j] = newElm;
			}
		}
	}
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	
	public static void main(String... args) {
		
		ShellSort shellSort = new ShellSort();
		shellSort.sort();
		StdOut.println(Arrays.toString(shellSort.arr));
		
	}
}
