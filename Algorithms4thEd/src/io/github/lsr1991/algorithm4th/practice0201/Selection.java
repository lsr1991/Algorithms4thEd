package io.github.lsr1991.algorithm4th.practice0201;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {

	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i ++) {
			int min = i;
			for (int j = i + 1; j < a.length; j ++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, min, i);
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i ++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i ++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
