package collectionsproblem;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class Demo1 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("Nehal");
		list.add("Lily");
		list.add("Isha");
		list.add("Harry");
		list.add("Dinesh");
		System.out.println("For each:-");
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("Iterator:-");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("List Iterator:-");
		ListIterator<String> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
		System.out.println("Enumeration:-");
		Enumeration<String> en = Collections.enumeration(list);
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}

}
