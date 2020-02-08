package coursera.algs4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class Main {

	static int[] rotLeft(int[] a, int d) {
		int [] b = new int[a.length];
		d = d % a.length;
		for (int i = 0; i < a.length; i++) {
			int j = (i + a.length - d) % a.length;
			StdOut.println(i+ " "+ (i + a.length - d) + " " + j);
			
			b[j] = a[i];
			StdOut.println(Arrays.toString(b));
		}
		return b;
	}
	public static void main(String... args) {
		StdOut.println(Arrays.toString(rotLeft(new int[]{1,2,3,4,5}, 4)));
	
	}
}
