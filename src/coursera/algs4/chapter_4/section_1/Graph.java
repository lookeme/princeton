package coursera.algs4.chapter_4.section_1;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * @author denisbelokopytov
 */
public class Graph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V; this.E = 0;
		adj = new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<>();
		}
		
		
	}
	
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(w, v);
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) degree++;
		return degree;
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

}
