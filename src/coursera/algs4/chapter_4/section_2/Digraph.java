package coursera.algs4.chapter_4.section_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class Digraph  {
	private int E;
	private int V;
	private Bag<Integer>[] adj;
	
	public Digraph(int V) {
		this.V = V;
		this.adj = new Bag[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new Bag<>();
		}
	}
	
	public Digraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
		
	}
	
	public int E() {
		return E;
	}
	
	public int V() {
		return V;
	}
	public Bag<Integer> adj(int v) {
		return adj[v];
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}
	
	public Digraph reverse() {
		Digraph reverse = new Digraph(V);
		for(int v = 0; v < V; v++) {
			for(int w : this.adj(v)) {
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}
	
	@Override
	public String toString() {
		
		String s = V + " вершин, " + E + " ребер\n";
		for(int v = 0; v < V; v++) {
			s += v + ": ";
			for(int w : adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		Digraph digraph = new Digraph(new In("algs4-data/tinyDG.txt"));
		edu.princeton.cs.algs4.Digraph digraph1 = new edu.princeton.cs.algs4.Digraph(new In("algs4-data/tinyDG.txt"));
		StdOut.println(digraph);
		StdOut.println(digraph1);
		
	}

}
