package coursera.algs4.chapter_1.section_3.bag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author denisbelokopytov
 */


public class Bag<Item> implements Iterable<Item>  {
	
	private Node first;
	
	private int size;
	

	
	private class Node<Item> {
		private Item value;
		private Node next;
		
		Node(Item item) {
			this.value = item;
		}
	}
	
	
	public void add(Item item) {
		Node temp = first;
		first = new Node(item);
		first.next = temp;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	
	private class ListIterator implements Iterator<Item> {
		Node current;
		private ListIterator(Node first) {
			this.current = first;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public Item next() {
			Item item = (Item) current.value;
			current = current.next;
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator(this.first);
	}
	
	public static void main(String[] args) {
		Bag<String> bag = new Bag<>();
		bag.add("1");
		bag.add("2");
		bag.add("3");
		bag.add("4");
		
		for (String st: bag) {
			StdOut.println(st);
		}
	}

	
	
}
