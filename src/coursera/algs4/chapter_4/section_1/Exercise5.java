package coursera.algs4.chapter_4.section_1;

import edu.princeton.cs.algs4.*;

/**
 * @author denisbelokopytov
 */
public class Exercise5 extends Graph {
	public Exercise5(int V) {
		super(V);
	}
	
	public Exercise5(In in) {
		super(in);
	}
	
	public boolean hasEdge(int v, int w) {
		Bag<Integer> bag = (Bag<Integer>) this.adj(v);
		for(int w2 : bag) {
			if(w == w2) return true;
		}
		return false;
	}
	
	@Override
	public void addEdge(int w, int v) {
		if(w == v || hasEdge(w,v)) return;
		super.addEdge(w, v);
	}
	
	public static void main(String[] args) {
		Exercise5 exercise5 = new Exercise5(4);
		exercise5.addEdge(0,1);
		exercise5.addEdge(1,2);
		exercise5.addEdge(2,3);
		exercise5.addEdge(3,0);
		StdOut.println(exercise5.toString());
	}
	
	
}
