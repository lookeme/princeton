package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class CountingSort {
	int[] array = { 1, 1, 3, 7, 7, 10, 12, 2, 2, 5 };
	
	public void countingSort(int min, int max) {
		
		int[] cntArray = new int[(max - min) + 1];
		
		for (int i = 0; i < array.length; i++) {
			cntArray[array[i] - min]++;
		}
		int j = 0;
		for (int i = min; i <= max; i++) {
			while(cntArray[i - min] > 0) {
				array[j++] = i;
				cntArray[i - min]--;
			}
			
		}
	}
	
	public static void  main(String... args) {
		CountingSort countingSort = new CountingSort();
		countingSort.countingSort(1, 12);
		StdOut.println(Arrays.toString(countingSort.array));
		
	}
}
