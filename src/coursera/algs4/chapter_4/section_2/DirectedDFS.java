package coursera.algs4.chapter_4.section_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class DirectedDFS {
	private boolean[] marked;
	
	public DirectedDFS(Digraph digraph, int s) {
		marked = new boolean[digraph.V()];
		dfs(digraph, s);
	}
	
	public DirectedDFS(Digraph digraph, Iterable<Integer> source) {
		marked = new boolean[digraph.V()];
		for(int s : source) {
			if(!marked[s]) dfs(digraph, s);
		}
	}
	
	private void dfs(Digraph digraph, int v) {
		marked[v] = true;
		for(int w : digraph.adj(v)) {
			if(!marked[w]) dfs(digraph, w);
		}
	}
	
	public boolean marked(int v) {
		return marked[v];
	}
	
	public static void main(String[] args) {
		Digraph digraph = new Digraph(new In(args[0]));
		
		Bag<Integer> source = new Bag<>();
		
		for(int i = 1; i < args.length; i++) {
			source.add(Integer.parseInt(args[i]));
		}
		
		DirectedDFS reachable = new DirectedDFS(digraph, source);
		
		for(int v = 0; v < digraph.V(); v++) {
			if(reachable.marked(v)) StdOut.print(v + " ");
		}
		StdOut.println();
		
		
	}
}
