package coursera.algs4.chapter_4.section_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
//class coursera.algs4.chapter_4.section_1.breadth.Graph {
//	private int V;
//	private int E;
//	private Bag<Integer>[] adj;
//
//	public coursera.algs4.chapter_4.section_1.breadth.Graph(int V) {
//		this.V = V;
//		this.E = 0;
//		this.adj = new Bag[V];
//		for(int i = 0; i < V; i++) {
//			adj[i] = new Bag<>();
//		}
//	}
//
//	coursera.algs4.chapter_4.section_1.breadth.Graph(In in) {
//		this(in.readInt());
//		int E = in.readInt();
//		for(int i = 0; i < E; i++) {
//			int v = in.readInt();
//			int w = in.readInt();
//			addEdge(w, v);
//		}
//
//	}
//
//	public int V() { return V; }
//	public int E() { return E; }
//
//	public void addEdge(int w, int v) {
//		adj[w].add(v);
//		adj[v].add(w);
//		E++;
//	}
//
//	public Iterable<Integer> adj(int v) {
//		return adj[v];
//	}
//
//	public boolean hasEdge(int v, int w) {
//		Bag<Integer> bag = adj[v];
//		for(int w2 : bag) {
//			if(w == w2) return true;
//		}
//		return false;
//	}
//
//	@Override
//	public String toString() {
//
//		String s = V + " вершин, " + E + " ребер\n";
//		for(int v = 0; v < V; v++) {
//			s += v + ": ";
//			for(int w : adj(v)) {
//				s += w + " ";
//			}
//			s += "\n";
//		}
//		return s;
//
//	}
//}

public class Exercise3 {
	
	public static Graph copyGraph(Graph G) {
		Graph graph = new Graph(G.V());
		for(int v = 0 ; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				graph.addEdge(w, v);
			}
		}
		return graph;
	}
	
	public static void main(String[] args) {
		In in = new In("algs4-data/tinyG.txt");
		Graph G = new Graph(in);
		Graph copy = Exercise3.copyGraph(G);
		copy.addEdge(9,8);
		StdOut.println(G);
		StdOut.println(copy);
		
		
		
		
	}
	
}
