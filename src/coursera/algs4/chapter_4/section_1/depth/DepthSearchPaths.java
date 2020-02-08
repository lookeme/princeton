package coursera.algs4.chapter_4.section_1.depth;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class DepthSearchPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	private int count;

	public DepthSearchPaths(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);

		for(int i = 0; i < edgeTo.length; i++) {
			StdOut.println(i +" -> " + edgeTo[i]);
		}


	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!hasPathTo(w)) {
				edgeTo[w] = v;
				count++;
				dfs(G, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<>();

		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		Integer s = Integer.valueOf(args[1]);
		Graph G = new Graph(in);
		for (int v = 0; v < G.V(); v++) {
			StdOut.print(v);
			for(int w : G.adj(v)) {
				StdOut.print( " -> " + w);
			}
			StdOut.println(" ");
		}

	}

}
