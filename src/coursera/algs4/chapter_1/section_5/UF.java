package coursera.algs4.chapter_1.section_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class UF implements UFI {
	private int[] id;
	private int count;
	
	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i< N; i++) {
			id[i] = i;
		}
		
	}
	
	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) return;
		id[pRoot] = qRoot;
		count--;
	}
	
	@Override
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		};
		return p;
	}
	
	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	@Override
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		
		In in = new In(args[0]);
		int N = Integer.valueOf(in.readLine());
	
		UF uf = new UF(N);
		while (!in.isEmpty()) {
			String line = in.readLine();
			int p = Integer.valueOf(line.split(" ")[0]);
			int q = Integer.valueOf(line.split(" ")[1]);
			if(uf.connected(p, q)) continue;
			uf.union(p,q);
			StdOut.println(p+ " "+q + " are connected");
		}
		StdOut.println(uf.count + " components!");
		StdOut.println(uf.find(0) + " f!");
		
	}
}
