package coursera.algs4.annagram;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class AnnagramApp {
	static int size;
	static int count;
	static char[] arrChar = new char[100];
	static int v = 0;
	
	public static void main(String... args){
	  String in =	StdIn.readString();
	  size = in.length();
	  for (int i = 0; i < size; i++) arrChar[i] = in.charAt(i);
	  doAnagram(size);
	  
	  
		
	}
	public static void rotate(int newSize) {
		int position = size - newSize;
		char temp = arrChar[position];
		int i;
		for (i = position + 1; i < size; i++) {
			arrChar[i-1] = arrChar[i];
		}
		arrChar[i-1] = temp;
	
	}
	public static void displayWord() {
		StdOut.print(++count+ " ");
		for (int i = 0; i < size; i++) StdOut.print(arrChar[i]);
		StdOut.print(" ");
		if (count%6 == 0) StdOut.print("");
		
	}
	
	public static void doAnagram(int size) {
		if (size == 1) return;
		for (int i = 0; i < size; i++) {
			doAnagram(size-1);
		  displayWord();
			rotate(size);
		}
		
	}

}
