import edu.princeton.cs.algs4.*;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;



/**
 * @author denisbelokopytov
 */

public class SAP {
	
	private class ProccesedData implements Comparable<ProccesedData> {
		private int ancestor = -1;
		private int length = -1;
		
		private ProccesedData(int length, int ancestor) {
			this.ancestor = ancestor;
			this.length = length;
		}
		
		private ProccesedData() {}
		
		@Override
		public int compareTo(ProccesedData proccesedData) {
			if (this.length <  proccesedData.length ) return -1;
			else if (this.length > proccesedData.length ) return 1;
			return 0;
		}
		
		public int getAncestor() {
			return ancestor;
		}
		
		public int getLength() {
			return length;
		}

	}

	private final Digraph G;
	private HashMap<String, ProccesedData> ancestor;
	
	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		this.G = new Digraph(G);
		this.ancestor = new HashMap<>();
	}
	
	private void checkCollection(Iterable<Integer> elements) {
		if(elements == null) throw new IllegalArgumentException();
		for(Object el : elements) {
			if(el == null) throw new IllegalArgumentException();
		}
	}
	private void validateVertex(int v) {
		if (v < 0 || v >= G.V())
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (G.V() - 1));
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		validateVertex(v); validateVertex(w);
		return process(v, w).getLength();
	}

	// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	public int ancestor(int v, int w) {
		validateVertex(v); validateVertex(w);
		return process(v, w).getAncestor();
	}
	
	private ProccesedData process(Iterable<Integer> v, Iterable<Integer> w) {
		String key = v.toString() + "_" + w.toString();
		if(ancestor.containsKey(key)) return ancestor.get(key);
		BreadthFirstDirectedPaths a = new BreadthFirstDirectedPaths(G, v);
		BreadthFirstDirectedPaths b = new BreadthFirstDirectedPaths(G, w);
	  List<ProccesedData> sortedList = new ArrayList<>();
		
		for (int i = 0; i < G.V(); i++) {
			if(a.hasPathTo(i) && b.hasPathTo(i)) {
				int ancestor = i;
				int len = a.distTo(i) + b.distTo(i);
				sortedList.add(new ProccesedData(len, ancestor));
			}
		}
		
		Collections.sort(sortedList);
		if (sortedList.isEmpty()) {
			return new ProccesedData();
		}
		ProccesedData result = sortedList.get(0);
		ancestor.put(key, result);
		return result;
	}

	private ProccesedData process(int v, int w) {
		String key = v + "_" + w;
		if(ancestor.containsKey(key)) return ancestor.get(key);
		BreadthFirstDirectedPaths a = new BreadthFirstDirectedPaths(G, v);
		BreadthFirstDirectedPaths b = new BreadthFirstDirectedPaths(G, w);
		List<ProccesedData> sortedList = new ArrayList<>();
		
		for (int i = 0; i < G.V(); i++) {
			if(a.hasPathTo(i) && b.hasPathTo(i)) {
				int ancestor = i;
				int len = a.distTo(i) + b.distTo(i);
				sortedList.add(new ProccesedData(len, ancestor));
			}
		}
		
		if (sortedList.isEmpty()) {
			return new ProccesedData();
		}
		Collections.sort(sortedList);
		ProccesedData result = sortedList.get(0);
		ancestor.put(key, result);
		return result;
	}

	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		checkCollection(v); checkCollection(w);
		return process(v, w).getLength();

	}


	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		checkCollection(v); checkCollection(w);
		return process(v, w).ancestor;
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		Digraph G = new Digraph(in);
		SAP sap = new SAP(G);
		while (!StdIn.isEmpty()) {
			int v = StdIn.readInt();
			int w = StdIn.readInt();
			int length   = sap.length(v, w);
			int ancestor = sap.ancestor(v, w);
			StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
		}
	}
}
