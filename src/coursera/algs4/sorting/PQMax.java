package coursera.algs4.sorting;

import edu.princeton.cs.algs4.StdOut;


import java.util.Arrays;

/**
 * @author denisbelokopytov
 */
public class PQMax<Item extends Comparable<Item>>  {
	private Item[] pq;
	private int size;
	public PQMax(int max) {
	 pq = (Item[]) new Comparable[max + 1];
	}
	

	
	public int getSize() { return size;}
	
	public void insert(Item a) {
		pq[++size] = a;
		swim(size);
		
	}
	
	public Item delMax() {
		Item max = pq[1];
		exch(1, size--);
		pq[size+1] = null;
		sink(1);
		return max;
	}
	
	private void sink(int k) {
		while(2*k <= size) {
			int j = 2 * k;
			if (j < size && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k,j);
			k = j;
			
		}
		
		
	}
	
	private void swim(int k) {
		while (k > 1 && less(k /2, k)) {
			exch(k/2, k);
			k = k/2;
		}
		
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j) {
		Item item = pq[i];
		pq[i] = pq[j];
		pq[j] = item;
		
	}
	
	public static void main(String... args) {
		
		PQMax<Character> pqMax = new PQMax<>(20);
		pqMax.insert('P');
		pqMax.insert('R');
		pqMax.insert('I');
		pqMax.insert('O');
		StdOut.println(Arrays.toString(pqMax.pq));
		pqMax.delMax();
		StdOut.println(Arrays.toString(pqMax.pq));
		pqMax.insert('R');
		StdOut.println(Arrays.toString(pqMax.pq));
		
		pqMax.delMax();
		pqMax.delMax();
		StdOut.println(Arrays.toString(pqMax.pq));
		
		pqMax.insert('I');
		pqMax.delMax();
		pqMax.insert('T');
		pqMax.delMax();
		pqMax.insert('Y');
		pqMax.delMax();pqMax.delMax();pqMax.delMax();
		pqMax.insert('Q');
		pqMax.insert('U');
		pqMax.insert('E');
		StdOut.println(Arrays.toString(pqMax.pq));
		
		pqMax.delMax();pqMax.delMax();pqMax.delMax();
		pqMax.insert('U');
		pqMax.delMax();
		pqMax.insert('E');
		StdOut.println(Arrays.toString(pqMax.pq));
	}
}
