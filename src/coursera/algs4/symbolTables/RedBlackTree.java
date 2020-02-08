package coursera.algs4.symbolTables;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
	private final static boolean RED = true;
	private final static boolean BLACK = false;
	
	private Node root;
	
	private class Node {
		private Node left, right;
		private Value value;
		private Key key;
		private int N;
		private boolean color;
		Node(Key key, Value value, int N, boolean color) {
			this.value = value;
			this.key = key;
			this.color = color;
			this.N = N;
		}
		
		private boolean isRed(Node x) {
			if (x == null) return false;
			return x.color == RED;
		}
		
		public int size(Node x) {
			if (x == null) return 0;
			return x.N;
		}
		public int size() {
			return size(root);
		}
		
		private Node rotateLeft(Node h) {
			Node x = h.right;
			h.right = x.left;
			x.left = h;
			x.color = h.color;
			h.color = RED;
			x.N = h.N;
			h.N = 1 + size(h.left) + size(h.right);
			return x;
		}
		
		private Node rotateRight(Node h) {
			Node x = h.left;
			h.left = x.right;
			x.right = h;
			x.color = h.color;
			h.color = RED;
			x.N = h.N;
			h.N = 1 + size(h.left) + size(h.right);
			return x;
		}
		
		private void flipColors(Node h) {
			h.color = RED;
			h.left.color = BLACK;
			h.right.color = BLACK;
			
		}
		
		
		public void put(Key key, Value value) {
			root = put(root, key, value);
			root.color = BLACK;
		}
		
		private Node put(Node h, Key key, Value value) {
			if (h == null) return new Node(key, value, 1, RED);
			
			int cmp = key.compareTo(h.key);
			
			if (cmp < 0) h.left = put(h.left, key, value);
			else if (cmp > 0) h.right = put(h.right, key, value);
			else h.value = value;
			
			if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
			if(isRed(h.left) && !isRed(h.left.left)) h = rotateRight(h);
			if(isRed(h.right) && !isRed(h.left)) flipColors(h);
			
			h.N = size(h.left) + size(h.right) + 1;
			return h;
			
			
			
			
			
		}
		
		
	}
	public static void main(String... args) {
		StdOut.println(Integer.valueOf('E'));
		StdOut.println(Integer.valueOf('S'));
	}
	
	
}
