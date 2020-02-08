package coursera.algs4.symbolTables;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author denisbelokopytov
 */
public class SequentialSearchST<Key, Value> implements Iterable<Key> {
	private Node first;
	
	@Override
	public Iterator<Key> iterator() {
		return new NodeIterator(first);
	}
	
	private class Node {
		private Key key;
		private Value val;
		private Node next;
		public  Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
		
		
	}
	public void put(Key key, Value val) {
		for (Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) x.val = val;
		}
		first = new Node(key, val, first);
	}
	
	public Value get(Key key) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) { return x.val; }
		}
		return null;
	}
	public Node delete(Key key) {
		if (key == null) throw new IllegalArgumentException();
		first = delete(first, key);
		return first;
	}
	
	public Node delete(Node x, Key key) {
		if(x == null) return null;
		if(key.equals(x.key)) return x.next;
		x.next = delete(x.next, key);
		return x;
	}
	
	Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for(Node x = first; x!= null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}

	class NodeIterator implements Iterator<Key> {
		private Node current;
		NodeIterator(Node first) {
			this.current = first;
		}
	
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public Key next() {
			if (!hasNext()) throw new NoSuchElementException();
			Key key = current.key;
			current = current.next;
			return key;
		}
	};
	
	}
	
