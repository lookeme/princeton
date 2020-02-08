package coursera.algs4.chapter_1;

import coursera.algs4.chapter_1.section_5.UF;
import coursera.algs4.chapter_1.section_5.UFI;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class WeightedQuickUnion implements UFI {
	private int[] id;
	private int[] sz;
	private int size;
	
	public WeightedQuickUnion(int N) {
		this.id = new int[N];
		this.sz = new int[N];
		for(int i = 0; i < N; i++) id[i] = i;
		for(int i = 0; i < N; i++) sz[i] = 1;
		this.size = N;
		StdOut.println(Arrays.toString(id));
		StdOut.println(Arrays.toString(sz));
		
	}
	
	@Override
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if(i==j) return;
		if(sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		else { id[j] = i; sz[i] += sz[j]; }
		size--;
		
	}
	
	@Override
	public int find(int p) {
		while (p!=id[p]) p = id[p];
		return p;
		
	}
	
	public int[] getSize() { return sz; }
	
	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	@Override
	public int count() {
		return size;
	}
	
	
	public static void main(String[] args) {
		
		In in = new In(args[0]);
		int N = Integer.valueOf(in.readLine());
		
		WeightedQuickUnion uf = new WeightedQuickUnion(N);
		while (!in.isEmpty()) {
			String line = in.readLine();
			int p = Integer.valueOf(line.split(" ")[0]);
			int q = Integer.valueOf(line.split(" ")[1]);
			if(uf.connected(p, q)) continue;
			uf.union(p,q);
			StdOut.println(p+ " "+q + " are connected");
		}
		StdOut.println(uf.count() + " components!");
		StdOut.println(uf.count() + " f!");
		
	}
}
