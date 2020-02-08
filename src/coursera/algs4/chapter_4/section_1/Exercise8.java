package coursera.algs4.chapter_4.section_1;


import coursera.algs4.chapter_1.WeightedQuickUnion;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
class Search {
	private WeightedQuickUnion uf;
	private int s;
	public Search(Graph G, int s) {
		this.s = s;
		this.uf = new WeightedQuickUnion(G.V());
		for(int v = 0; v <  G.V(); v++) {
			for(int w : G.adj(v)) {
				uf.union(v, w);
			}
		}
	}
	public int count(int v) {
		return  this.uf.find(v);
	}
	
	public boolean marked(int v) {
		return uf.connected(s, v);
	}
	
	
	
	public int count() {
		int sourceVertexLeader = uf.find(s);
		return uf.getSize()[sourceVertexLeader];
	}
}

public class Exercise8 {
	
	public static void main(String[] args) {

		Graph G = new Graph(new In(args[0]));
		int s = Integer.valueOf(args[1]);
		Search search = new Search(G, s);

		for (int v = 0; v < G.V(); v++) {
			if(search.marked(v)) { StdOut.print(v + " "); }
		}
		StdOut.println();
		if (search.count() != G.V()) {
			StdOut.print("НЕ ");
		}
		StdOut.print("связный " + search.count());

	}
}
