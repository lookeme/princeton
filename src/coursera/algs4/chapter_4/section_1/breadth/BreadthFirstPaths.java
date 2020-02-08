package coursera.algs4.chapter_4.section_1.breadth;


import coursera.algs4.chapter_4.section_1.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class BreadthFirstPaths {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	private int[] distTo;
	
	public BreadthFirstPaths(Graph G, int s) {
		this.s = s;
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		bfs(G, s);
		StdOut.println(Arrays.toString(edgeTo));
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new Queue<>();
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				if (!hasPathTo(w)) {
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public int distTo(int v) {
		return distTo[v];
	}
	


	
	public boolean hasPathTo(int v) { return marked[v]; }
	
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
	
}
