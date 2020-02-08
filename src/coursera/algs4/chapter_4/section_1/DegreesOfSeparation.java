package coursera.algs4.chapter_4.section_1;


import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class DegreesOfSeparation {
//	public static void main(String[] args) {
//		StdOut.println(Arrays.toString(args));
//		coursera.algs4.chapter_4.section_1.breadth.SymbolGraph sg = new coursera.algs4.chapter_4.section_1.breadth.SymbolGraph(args[0], args[1]);
//		coursera.algs4.chapter_4.section_1.breadth.Graph G = sg.graph();
//		String source = args[2];
//		if(!sg.contains(source)) {
//			System.out.println(source + "is not found in the db !");
//		}
//
//		int s = sg.index(source);
//		System.out.println(s + " is index");
//		BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(G, s);
//
//		while (!StdIn.isEmpty()) {
//			String sink = StdIn.readLine();
//			StdOut.println(sink);
//			if(sg.contains(sink)) {
//				int v = sg.index(sink);
//				if(breadthFirstPaths.hasPathTo(v)) {
//					for(int w : breadthFirstPaths.pathTo (v)) {
//						StdOut.println(" sss  " +w+  "  " + sg.nameOf(w));
//					}
//				} else {
//					StdOut.println("Не связаны!");
//				}
//
//			} else {
//				StdOut.println(sink + " is not in base!");
//			}
//		}
//
//	}
}
