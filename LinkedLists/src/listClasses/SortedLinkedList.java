package listClasses;

import java.util.*;

/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 * @author Dept of Computer Science, UMCP
 * 
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {

	private Comparator<T> comparator;

	// Constructor calls the super class constructor and sets the comparator
	// parameter
	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;

	}

	// Adds the node in the correct position based on the compare method.
	public SortedLinkedList<T> add(T element) {
		// Create new Node
		Node newNode = new Node(element);
		Node curr = head;
		Node prev = null;

		// Checks to make sure reference isn't past the end of the list
		while (curr != null
				&& this.comparator.compare(element, curr.data) >= 0) {
			// Updates reference pointers
			prev = curr;
			curr = curr.next;
		}
		// Checks if prev is null and then adds newNode
		if (prev == null) {
			newNode.next = head;
			head = newNode;

		} else {
			// Adds new Node to the linkedList
			newNode.next = curr;
			prev.next = newNode;
		}
		// Updates the listSize variable and returns the current list
		listSize++;
		return this;
	}

	// Calls the super.remove method from the BasicLinkedList class and casts
	// the
	// return value to the type of SortedLinkedList. Returns the value
	public SortedLinkedList<T> remove(T targetData) {
		return (SortedLinkedList<T>) super.remove(targetData, this.comparator);
	}

	// Throws an UnsupportedOperationException because this class cannot
	// implement this method.
	public BasicLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException(
				"Invalid operation for sorted list.");
	}
	// Throws an UnsupportedOperationException because this class cannot
	// implement this method.
	public BasicLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException(
				"Invalid operation for sorted list.");
	}
}