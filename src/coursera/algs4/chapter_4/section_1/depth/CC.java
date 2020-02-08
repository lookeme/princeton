package coursera.algs4.chapter_4.section_1.depth;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class CC {

	private boolean[] marked;
	private int[] id;
	private int count;

	CC(Graph G) {
		int capacity = G.V();
		marked = new boolean[capacity];
		id = new int[capacity];
		for(int s = 0; s < capacity; s++) {
			if(!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	public void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)) {
			if(!marked[w]) dfs(G, w);
		}
	}


	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}
	public int count() {
		return count;
	}

	public static void main(String... args) {
		In in = new In("algs4-data/tinyG.txt");
		Graph G = new Graph(in);
		CC cc = new CC(G);
		int num = cc.count;
		StdOut.println(num + " components");

		Bag<Integer>[] components = (Bag<Integer>[]) new Bag[num];

		for(int i = 0; i < num; i++) {
			components[i] = new Bag<>();
		}

		for(int v = 0; v < G.V(); v++) {
			int componentId = cc.id(v);
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
