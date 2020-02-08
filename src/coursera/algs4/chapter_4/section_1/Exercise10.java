package coursera.algs4.chapter_4.section_1;

import coursera.algs4.chapter_4.section_1.depth.DepthSearchPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * @author denisbelokopytov
 */
public class Exercise10 {
	
	public static void main(String[] args) {
		In in = new In("algs4-data/tinyGex2.txt");
		Graph G = new Graph(in);
		DepthSearchPaths searchPaths = new DepthSearchPaths(G, 0);
		
		
//		for (int v = 0; v < G.V(); v++) {
//			if(search.marked(v)) { StdOut.print(v + " "); }
//		}
//		StdOut.println();
//		if (search.count() != G.V()) {
//			StdOut.print("НЕ ");
//		}
//		StdOut.print("связный " + search.count());
	
	}

}
