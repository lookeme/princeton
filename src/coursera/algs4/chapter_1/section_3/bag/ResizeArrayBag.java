package coursera.algs4.chapter_1.section_3.bag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author denisbelokopytov
 */
public class ResizeArrayBag<Item> implements Iterable<Item> {
	
	private Item[] items;
	private int n;
	
	public ResizeArrayBag() {
		this.items = (Item[]) new Object[2];
		this.n = 0;
	}
	
	
	public void add(Item item) {
		if(items.length <= n) resize(2*items.length);
		items[n++] = item;
		
	}
	
	private void resize(int capacity) {
		Item[] resized = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			resized[i] = items[i];
		}
		items = resized;
		
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	
	class ArrayIterator implements Iterator<Item> {
		
		private int i = 0;
		
		@Override
		public boolean hasNext() {
			return i < n;
		}
		
		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			return items[i++];
		}
		
		@Override
		public void remove() {
			throw  new UnsupportedOperationException();
			
		}
	}
	
	public static void main(String[] args) {
		ResizeArrayBag<String> bag = new ResizeArrayBag();
		bag.add("2");
		bag.add("tyy");
		bag.add("rrtrt");
		bag.add("rrgvr");
		bag.add("ttt");
		for (String st: bag){
			StdOut.println(st);
		}
		
		
		
		}
}


