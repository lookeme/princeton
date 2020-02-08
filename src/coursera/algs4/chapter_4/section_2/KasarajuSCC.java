package coursera.algs4.chapter_4.section_2;

import coursera.algs4.chapter_4.section_1.depth.CC;
import edu.princeton.cs.algs4.*;

/**
 * @author denisbelokopytov
 */
public class KasarajuSCC {
	private boolean marked[];
	private int[] id;
	private int count;
	
	public KasarajuSCC(Digraph digraph) {
		marked = new boolean[digraph.V()];
		id = new int[digraph.V()];
		DepthFirstOrder order = new DepthFirstOrder(digraph.reverse());
		
		for(int s : order.getReverse()) {
			if(!marked[s]) {
				dfs(digraph, s);
				count++;
			}
		}
		
	}
	
	private void dfs(Digraph digraph, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w: digraph.adj(v)) {
			if(!marked[w]) {
				dfs(digraph, w);
			}
		}
	}
	
	public boolean isStronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String... args) {
		In in = new In("algs4-data/tinyDG.txt");
		Digraph digraph = new Digraph(in);
		StdOut.println(digraph);
		KasarajuSCC scc = new KasarajuSCC(digraph);
		int num = scc.count();
		StdOut.println(num + " components");
		
		Bag<Integer>[] components = (Bag<Integer>[]) new Bag[num];
		
		for(int i = 0; i < num; i++) {
			components[i] = new Bag<>();
		}
		
		for(int v = 0; v < digraph.V(); v++) {
			int componentId = scc.id(v);
			components[componentId].add(v);
		}
		
		for(int i = 0; i < num; i++) {
			for(int v: components[i]) {
				StdOut.print(v+"  ");
			}
			StdOut.println();
			
		}
	}
}
