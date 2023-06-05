package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	// Testing getSize, addToFront, and addToEnd methods
	// Also Tests getFirst and getLast methods
	public void test1() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToFront("Red").addToFront("Yellow").addToEnd("Blue");
		assertEquals(basicList.getSize(), 3);
		assertEquals(basicList.getFirst(), "Yellow");
		assertEquals(basicList.getLast(), "Blue");

		BasicLinkedList<String> list2 = new BasicLinkedList<String>();
		list2.addToEnd("RED");
		assertEquals(list2.getFirst(), "RED");

		assertEquals(list2.getLast(), "RED");
	}

	@Test
	// Testing multiple methods with null cases
	public void test2() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		assertEquals(basicList.getFirst(), null);
		assertEquals(basicList.getLast(), null);
		assertEquals(basicList.retrieveFirstElement(), null);
		assertEquals(basicList.retrieveLastElement(), null);
		assertEquals(basicList.getSize(), 0);

		assertEquals(basicList.getReverseArrayList().toString(), "[]");

		assertEquals(basicList.getReverseList().getFirst(), null);
		assertEquals(basicList.getReverseList().getLast(), null);
	}

	@Test
	// Testing remove, retrieveFirstElement, and retrieveLastElement methods
	public void test3() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToFront("Red");
		basicList.addToFront("Yellow");
		basicList.addToFront("Blue");
		basicList.addToFront("Orange");
		assertEquals(basicList.retrieveFirstElement(), "Orange");

		assertEquals(basicList.retrieveLastElement(), "Red");
		assertEquals(basicList.getSize(), 2);

		basicList.remove("Yellow", String.CASE_INSENSITIVE_ORDER);
		basicList.remove("Blue", String.CASE_INSENSITIVE_ORDER);
		assertEquals(basicList.getSize(), 0);

		BasicLinkedList<String> basicList2 = new BasicLinkedList<String>();
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");

		basicList2.addToFront("Red");
		basicList2.addToFront("Blue");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");
		basicList2.addToFront("Red");

		basicList2.addToFront("Red");

		basicList2.remove("Red", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals(basicList2.getFirst(), "Blue");
		assertEquals(basicList2.getLast(), "Blue");
		assertEquals(basicList2.getSize(), 1);

	}

	@Test
	// Testing getReverseArrayList
	public void test4() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToEnd("Yellow").addToEnd("Blue")
				.addToEnd("Orange");
		assertEquals(basicList.getReverseArrayList().toString(),
				"[Orange, Blue, Yellow, Red]");
	}

	@Test
	// Testing getReverseList
	public void test5() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToEnd("Yellow").addToEnd("Blue")
				.addToEnd("Orange");
		BasicLinkedList<String> basicList2 = new BasicLinkedList<String>();
		basicList2.addToEnd("Orange").addToEnd("Blue").addToEnd("Yellow")
				.addToEnd("Red");
		assertEquals(basicList.getReverseList().getFirst(),
				basicList2.getFirst());
		assertEquals(basicList.getReverseList().getLast(),
				basicList2.getLast());

	}

	@Test
	// Testing iterator
	public void test6() {
		BasicLinkedList<Integer> basicList = new BasicLinkedList<Integer>();
		basicList.addToFront(2);
		basicList.addToFront(1);
		assertEquals(basicList.iterator().hasNext(), true);
		BasicLinkedList<String> list2 = new BasicLinkedList<String>();
		list2.addToEnd("Yellow");
		list2.addToEnd("Red");
		list2.addToEnd("Orange");
		assertEquals(list2.iterator().next(), "Yellow");
	}

	@Test(expected = UnsupportedOperationException.class)
	// Tests UnsupportedOperationException methods
	public void test7() {
		SortedLinkedList<String> list = new SortedLinkedList<String>(
				String.CASE_INSENSITIVE_ORDER);
		list.addToEnd("Red");
		list.addToFront("Red");
	}
	@Test(expected = UnsupportedOperationException.class)
	// Tests UnsupportedOperationException methods
	public void test8() {
		SortedLinkedList<String> list = new SortedLinkedList<String>(
				String.CASE_INSENSITIVE_ORDER);
		
		list.addToFront("Red");
	}

	@Test
	// Testing add for SortedLinkedLists
	public void test9() {
		SortedLinkedList<String> list = new SortedLinkedList<String>(
				String.CASE_INSENSITIVE_ORDER);
		list.add("f").add("q").add("n").add("v").add("o").add("z");
		String s = "";
		for (String entry : list) {
			s += (entry + " ");
		}
		assertEquals(s, "f n o q v z ");

		SortedLinkedList<String> list2 = new SortedLinkedList<String>(
				String.CASE_INSENSITIVE_ORDER);
		list2.add("z").add("z").add("z").add("a").add("a").add("z");
		String a = "";
		for (String entry : list2) {
			a += (entry + " ");
		}
		assertEquals(a, "a a z z z z ");

		SortedLinkedList<String> list3 = new SortedLinkedList<String>(
				String.CASE_INSENSITIVE_ORDER);
		list3.add("a").add("a");
		String g = "";
		for (String entry : list3) {
			g += (entry + " ");
		}
		assertEquals(g, "a a ");
		
		
	}

	@Test
	// Testing remove for SortedLinkedLists
	public void test10() {
		SortedLinkedList<String> list = new SortedLinkedList<String>(
				String.CASE_INSENSITIVE_ORDER);
		list.add("f").add("e").add("d").add("c").add("b").add("a");
		String s = "";
		for (String entry : list) {
			s += (entry + " ");
		}
		assertEquals(s, "a b c d e f ");
		list.remove("a");
		assertEquals(list.getSize(),5);
		String f = "";
		for (String entry : list) {
			f += (entry + " ");
		}
		assertEquals(f, "b c d e f ");
		
		
		SortedLinkedList<String> list2 = new SortedLinkedList<String>(
				String.CASE_INSENSITIVE_ORDER);
		list2.add("a").add("a").add("a").add("b");
		
		list2.remove("a");
		String j = "";
		for (String entry : list2) {
			j += (entry + " ");
		}
		assertEquals(j, "b ");
	}

}
