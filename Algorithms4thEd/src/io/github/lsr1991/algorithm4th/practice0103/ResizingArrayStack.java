package io.github.lsr1991.algorithm4th.practice0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] a;
	private int N;
	
	public ResizingArrayStack(int cap) {
		a = (Item[])new Object[cap];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(Item item) {
		if (N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = item;
	}
	
	public Item pop() {
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		Item item = a[--N];
		a[N] = null; // avoid object loitering
		return item;
	}
	
	private void resize(int cap) {
		Item[] b = (Item[])new Object[cap];
		for (int i = 0; i < b.length; i ++) {
			b[i] = a[i];
		}
		a = b;
	}
	
	public Iterator<Item> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() {
			return i > 0;
		}
		public Item next() {
			return a[--i];
		}
		public void remove() {
			// nothing
		}
	}
	public static void main(String[] args) {
		ResizingArrayStack<String> s = new ResizingArrayStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
		for (String item : s) {
			StdOut.println(item);
		}
	}

}
