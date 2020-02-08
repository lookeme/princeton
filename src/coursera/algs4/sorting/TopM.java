package coursera.algs4.sorting;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;


/**
 * @author denisbelokopytov
 */
public class TopM<Item extends Comparable<Item>> {
	private Item[] pq;
	private int size;
	
	public TopM(int max) {
		pq = (Item[]) new Comparable[max+1];
	}
	
	public void swim(int k) {
		while (k > 1 && less(k , k /2))  {
			exch(k, k/2);
			k = k /2;
		}
	}
	
	public void sink(int k) {
		while (2*k <= size) {
			int j = 2*k;
			if(j < size && less(j, j+1) ) j++;
			if(!less(k, j)) break;
			exch(k,j);
			k = j;
		}
	}
	
	private void exch(int i, int j) {
		Item item = pq[i];
		pq[i] = pq[j];
		pq[j] = item;
		
	}
	public boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	public void insert(Item item) {
		pq[++size] = item;
		swim(size);
	}
	
	public Item delMax() {
		Item max = pq[1];
		exch(1, size--);
		pq[size+1] = null;
		sink(1);
		return max;
	}
	
	static class Point implements Comparable<Point> {
		private  int x, y, z;
		Point(int x, int y , int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
			
			public double getDistance() {
				return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
		}
		
		@Override
		public int compareTo(Point o) {
			if (this.getDistance() - o.getDistance() > 0) return 1;
			else if (this.getDistance() - o.getDistance() < 0) return -1;
			else return 0;
		}
		
		@Override
		public String toString() {
			return "Point{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				", dist="+ getDistance()+
				'}';
		}
	}
	
	public static void main(String... args) {
		MinPQ<Point> topM = new MinPQ<Point>(10+1);
//		TopM<Point> topM = new TopM<>(10);
		topM.insert(new Point(1,2,3));
		topM.insert(new Point(2,3,4));
		topM.insert(new Point(3,4,5));
		topM.insert(new Point(4,5,6));
		Point point= topM.delMin();
		StdOut.println(point);
		
		Point point2= topM.delMin();
		StdOut.println(point2);
		
		
	}
	
	}
	

