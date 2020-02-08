package coursera.algs4.chapter_4.section_1;

import coursera.algs4.chapter_4.section_1.breadth.BreadthFirstPaths;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class Exercise13 {
	public static void main(String[] args) {
		In in = new In("algs4-data/tinyGex2.txt");
		Graph G = new Graph(in);
		
		
		BreadthFirstPaths b = new BreadthFirstPaths(G, 0);
		
		for (int v = 0; v < G.V(); v++) {
			StdOut.print(0 + " to " + v + ": ");
			if(b.hasPathTo(v)) {
				for(int x : b.pathTo(v)) {
					if(0 == x) StdOut.print(x);
					else StdOut.print("-" + x);
				}
			
			}
			StdOut.println();
		}
		StdOut.println(" d 1 = " + b.distTo(10));
//		StdOut.println(" d 2 = " + b.getDistTo(10));
	}
}
