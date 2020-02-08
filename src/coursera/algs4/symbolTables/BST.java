package coursera.algs4.symbolTables;

/**
 * @author denisbelokopytov
 */
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node {
		private Node left;
		private Node right;
		private Key key;
		private Value value;
		private int N;
		
		Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
		
		public int size() {
			return size(root);
		}
		
		private int size(Node x) {
			if (x == null) return 0;
			return x.N;
		}
		
		public Value get(Key key){
			return get(root, key);
		}
		
		public Value get(Node x, Key key){
			if(x == null) return null;
			int comp = key.compareTo(x.key);
			if (comp < 0) return get(x.left, key);
			else if (comp > 0) return get(x.right, key);
			else return x.value;
		}
		
		
		public void put(Key key, Value val) {
			root = put(root, key, value);
			
		}
		
		public Key min() {
			return min(root).key;
		}
		
		public Node min(Node x) {
			if (x.left == null) return null;
			return min(x.left);
		}
		
		public Key max() {
			return min(root).key;
		}
		
		public Node max(Node x) {
			if (x.right == null) return null;
			return min(x.right);
		}
		
		public Key floor(Key key) {
			Node floor = floor(root, key);
			if (floor == null) return null;
			return floor.key;
		}
		
		public Node floor(Node x, Key key) {
			if (x == null) return null;
			int comp = key.compareTo(x.key);
			if (comp == 0) return x;
			if (comp < 0) return floor(x.left, key);
			Node t = floor(x.right, key);
			if (t != null) return t;
			return x;

		}
		
		
		
		private Node put(Node x, Key key, Value value) {
			if (x==null) return new Node(key, value, 1);
			int comp = key.compareTo(x.key);
			if (comp < 0) return put(x.left, key, value);
			else if (comp > 0) return put(x.right, key, value);
			else x.value = value;
			x.N = size(x.left) +  size(x.right) + 1;
			return x;
		}
		
	}
}
