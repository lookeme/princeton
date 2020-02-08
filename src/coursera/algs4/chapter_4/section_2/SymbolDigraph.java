package coursera.algs4.chapter_4.section_2;

import coursera.algs4.chapter_4.section_1.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;


/**
 * @author denisbelokopytov
 */
public class SymbolDigraph {
	
	private ST<String, Integer> st;
	private String[] keys;
	private Digraph digraph;
	private Graph graph;
	
	
	public SymbolDigraph(String stream, String sp) {
		st = new ST();
		In in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			for (int i = 0; i < a.length; i++) {
				if(!st.contains(a[i])) st.put(a[i], st.size());
			}
		}
		
		keys = new String[st.size()];
		
		for(String name : st.keys()) {
			keys[st.get(name)] = name;
		}
		this.digraph = new Digraph(st.size());
		this.graph = new Graph(st.size());
		in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				digraph.addEdge(v, st.get(a[i]));
				graph.addEdge(v, st.get(a[i]));
			}
		}
	}
	
	@Override
	public String toString() {
		
		String s = digraph.V() + " вершин, " + digraph.E() + " ребер\n";
		for(int v = 0; v < digraph.V(); v++) {
			s += name(v) + ": ";
			for(int w : digraph.adj(v)) {
				s += name(w) + ", ";
			}
			s += "\n";
		}
		return s;
		
	}
	
	
	public boolean contains(String s) { return st.contains(s); }
	public int index(String s) { return st.get(s); }
	public String name(int v) { return keys[v]; }
	public Digraph getDigraph() { return digraph; }
	

	
	}
	
