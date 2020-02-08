package coursera.algs4.chapter_4.section_1.depth;

import edu.princeton.cs.algs4.*;

import java.util.Iterator;

/**
 * @author denisbelokopytov
 */
public class DepthFirstSearch {
	private boolean[] marked;
	Iterator<Integer>[] adj;

	private int count;
	public DepthFirstSearch(Graph G, int s) {
		adj = (Iterator<Integer>[]) new Iterator[G.V()];
		marked = new boolean[G.V()];
		
		for (int v = 0; v < G.V(); v++)
				adj[v] = G.adj(v).iterator();
//		dfs(G, s);
		nonRecursiveDfs(s);

	}

	public void dfs(Graph G, int v) {
		marked[v] = true;
		count++;
		for(int w: G.adj(v)) {
			if(!marked(w)) {
				dfs(G, w);
			}
		}
	}
	
	
	public void nonRecursiveDfs(int s) {
		// depth-first search using an explicit stack
		Stack<Integer> stack = new Stack<Integer>();
		marked[s] = true;
		stack.push(s);
		while (!stack.isEmpty()) {
			int v = stack.peek();
			if (adj[v].hasNext()) {
				int w = adj[v].next();
				// StdOut.printf("check %d\n", w);
				if (!marked[w]) {
					// discovered vertex w for the first time
					marked[w] = true;
					// edgeTo[w] = v;
					stack.push(w);
					// StdOut.printf("dfs(%d)\n", w);
				}
			}
			else {
				// StdOut.printf("%d done\n", v);
				stack.pop();
			}
		}
	}
	public boolean marked(int v) { return marked[v]; }

	public boolean connected(Graph G) {
		return G.V() == count;
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		int s = Integer.parseInt(args[1]);
		DepthFirstSearch search = new DepthFirstSearch(G, s);
		for (int v = 0; v < G.V(); v++)
			if (search.marked(v))
				StdOut.print(v + " ");
		StdOut.println();
	}
}
