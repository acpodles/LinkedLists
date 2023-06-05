package listClasses;

import java.util.*;

public class BasicLinkedList<T> implements Iterable<T> {

	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;

	/* size */
	protected int listSize;

	// Constructor sets head to null and listSize to 0;
	public BasicLinkedList() {
		head = null;
		listSize = 0;	
	}

	// Returns the listSize variable
	public int getSize() {
		return this.listSize;
	}

	// Adds the Node to the end of the linkedList
	public BasicLinkedList<T> addToEnd(T data) {
		// Create newNode
		Node newNode = new Node(data);
		// Checks if the list is empty, if so add node to beginning and return
		if (head == null) {
			head = new Node(data);
			this.listSize++;
			return this;
		}
		// Updates newNode and loops until it reaches the end of the LinkedList.
		// Then, add the node and increment the listSize. Return list.
		newNode.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		this.listSize++;
		return this;
	}

	// Adds the newNode to the front of the list
	public BasicLinkedList<T> addToFront(T data) {
		// Creates new Node with the data
		Node newNode = new Node(data);
		// Adds node to the front, increments listSize, and returns list
		newNode.next = head;
		head = newNode;
		this.listSize++;
		return this;
	}

	// Returns the data in the first node
	public T getFirst() {
		// Checks if head is null or list is empty
		if (head == null) {
			return null;
		}
		// Returns data at the head node
		Node curr = head;
		return curr.data;
	}

	// Returns the data in the last node
	public T getLast() {
		// Checks if head is null or list is empty
		if (head == null) {
			return null;
		}
		Node curr = head;
		// Loops through the list until it reaches the end
		while (curr.next != null) {
			curr = curr.next;
		}
		// Returns the data at the last position of the list
		return curr.data;
	}

	// Gets the first element and deletes it
	public T retrieveFirstElement() {
		// Checks if list is null
		if (head == null) {
			return null;
		}
		// Stores the data in a variable and deletes that node
		T data = head.data;
		head = head.next;
		// Increments the listSize variable and returns the data in the deleted
		// node
		this.listSize--;
		return data;
	}

	// Gets the last element in the list and deletes it
	public T retrieveLastElement() {
		if (head == null) {
			return null;
		}
		// Creates references and loops through the list until it gets to the
		// end
		Node remove = head;
		Node curr = head;
		while (curr != null) {
			if (curr.next.next == null) {
				remove = curr;
				break;
			}
			curr = curr.next;
		}
		// Stores data from the last position. Deletes the element and returns
		// the data
		T data = remove.next.data;
		remove.next = null;
		this.listSize--;
		return data;

	}

	// Tested
	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node prev = null;
		// Iterates through the list and compares the nodes data to the target
		// data
		while (head != null
				&& (comparator.compare(head.data, targetData) == 0)) {
			head = head.next;
			this.listSize--;
		}
		// nothing is removed if list is empty
		if (head == null) {
			return null;
		}
		Node curr = head;
		// Checks each node in the list and removes all that are the same as the
		// target
		while (curr.next != null) {
			if (comparator.compare(curr.data, targetData) == 0) {
				prev.next = curr.next;
				curr = curr.next;
				this.listSize--;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		// Increments listSize after every removal of data
		if (comparator.compare(curr.data, targetData) == 0) {
			prev.next = null;
			curr = prev;
			this.listSize--;
		}
		// Returns current list
		return this;
	}

	public Iterator<T> iterator() {
		// Creates new Iterator and anonymous class
		Iterator<T> iterator = new Iterator<T>() {
			Node curr = head;

			// Implements the hasNext and Next methods from the iterator
			// interface
			@Override
			public boolean hasNext() {
				// Returns true if the current node has a next node
				return curr != null;
			}

			@Override
			public T next() {
				// checks if node hasNext and returns the data
				if (hasNext()) {
					T data = curr.data;
					curr = curr.next;
					return data;
				} else {
					return null;
				}

			}
		};
		// Return the iterator
		return iterator;
	}

	// Tested
	// This method calls the helper method which performs the recursion
	public ArrayList<T> getReverseArrayList() {
		// Create new ArrayList
		ArrayList<T> result = new ArrayList<T>();
		// Call recursive method
		getReverseArrayList(head, result);
		// Returns ArrayList
		return result;
	}

	// Tested
	// Helper method to recursively reverse the LinkedList
	private void getReverseArrayList(Node head, ArrayList<T> result) {
		if (head == null) {
			return;
		}
		// Recursively calls the method and increments the parameter thats
		// passed in
		getReverseArrayList(head.next, result);
		// Adds the data to the arrayList defined in the original method
		result.add(head.data);
	}

	public BasicLinkedList<T> getReverseList() {
		// Create new BasicLinkedList
		BasicLinkedList<T> basicList = new BasicLinkedList<T>();
		// Call recursive methods
		getReverseList(head, basicList);
		// Returns new LinkedList
		return basicList;

	}

	public void getReverseList(Node head, BasicLinkedList<T> basicList) {
		// Checks if LinkedList is empty
		if (head == null) {
			return;
		}
		// Recursively calls same method and increments parameter after each
		// call
		getReverseList(head.next, basicList);
		//Adds the returned values to the new LinkedList
		basicList.addToEnd(head.data);

	}
}