package coursera.algs4.symbolTables;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class STsearch {
	public static void main(String... args) {
		BinarySearchST<String, Integer> st = new BinarySearchST(15);
		st.put("E",6);
		st.put("C",65);
		st.put("B",5);
		st.put("C",65);
		st.put("D",62);
		st.put("A",1);
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
		
		st.delete("D");
		
		StdOut.println("___________");
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}
