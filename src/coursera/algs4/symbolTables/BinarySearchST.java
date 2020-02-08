package coursera.algs4.symbolTables;

import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author denisbelokopytov
 */
public class BinarySearchST<Key extends Comparable<Key>, Value>  {
	private Key[] keys;
	private Value[] values;
	private int N;
	
	BinarySearchST(int capacity) {
		keys = (Key[])  new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}
	public int size() {return N; }
	public boolean isEmpty() { return N == 0; }
	
	public int rank(Key key) {
		if(key == null) throw new IllegalArgumentException();
		int rank = rank(0, N - 1, key);
		return rank;
	}
	
	public int rank(int lo, int hi, Key key) {
		if (hi < lo) return lo;
		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(keys[mid]);
		if (cmp > 0) return rank(mid + 1, hi, key);
		else if (cmp < 0) return rank(lo , mid -1, key);
		else return mid;
	}
	
	public void put(Key key, Value value) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}
		for(int j = N; j > i; j--) {
			keys[j] = keys[j-1]; values[j] = values[j-1];
		}
		keys[i] = key; values[i] = value;
		N++;
	}
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) return values[i];
		else return null;
	}
	
	public Value delete(Key key) {
		if(key == null) throw  new IllegalArgumentException();
		if (isEmpty()) return null;
		int i = rank(key);
		
		if (N < i && key.compareTo(keys[i]) != 0) return null;
		Value result = values[i];
		
		for(int j = i; j < N -1; j++) {
			keys[j] = keys[j+1];
			values[j] = values[j+1];
		}
		N--;
	
		keys[N] = null;
		values[N] = null;
		return result;
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<>();
		for (int i = rank(lo); i < rank(hi); i++) {
			queue.enqueue(keys[i]);
			
		}
		return queue;
	}
	
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[N-1];
	}
	
	
	
}
