package coursera.algs4.chapter_4.section_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author denisbelokopytov
 */
public class DirectedCycle {
	private boolean[] onStack;
	private int[] edgeTo;
	private boolean[] marked;
	private Stack<Integer> cycle;
	

	
	public DirectedCycle(Digraph G) {
		int cap = G.V();
		this.onStack = new boolean[cap];
		this.marked = new boolean[cap];
		this.edgeTo = new int[cap];
		this.onStack = new boolean[cap];
		
		for(int v = 0; v < cap; v++) {
			if(!marked[v] && cycle != null) dfs(G, v);
		}
	}
	
	private void dfs(Digraph digraph, int v) {
		marked[v] = true;
		onStack[v] = true;
		
		for(int w : digraph.adj(v)) {
			if(cycle != null) return;
			
			else if(!marked[w]) { edgeTo[w] = v; dfs(digraph, w); }
			
			else if(onStack[w]) {
				cycle = new Stack<>();
				for(int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
			onStack[v] = false;
		}
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Stack<Integer> cycle() {
		return cycle;
	}
	
	public static void main(String[] args) {
		Digraph digraph = new Digraph(new In(args[0]));
		DirectedCycle cycle = new DirectedCycle(digraph);
		if(cycle.hasCycle()) {
			StdOut.println("There is a cycle in the digraph");
			for(int v : cycle.cycle()) {
				StdOut.print(v + " -> ");
			}
			StdOut.println();
		}
		else {
			StdOut.println("There are no cycle in the digraph!");
		}
	}
}
