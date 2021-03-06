package com.example.app.linkedList;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Iterator;

class LinkedListTest {

	@Test
	void testInsertionInFront() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInFront(1);
		linkedList.insertInFront(2);
		linkedList.insertInFront(3);
		linkedList.insertInFront(4);

		Iterator<Integer> iterator = linkedList.iterator();
		Assert.isTrue(iterator.next()==4);
		Assert.isTrue(iterator.next()==3);
		Assert.isTrue(iterator.next()==2);
		Assert.isTrue(iterator.next()==1);
	}

	@Test
	void testInsertionInEnd() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInEnd(1);
		linkedList.insertInEnd(2);
		linkedList.insertInEnd(3);
		linkedList.insertInEnd(4);

		Iterator<Integer> iterator = linkedList.iterator();
		Assert.isTrue(iterator.next()==1);
		Assert.isTrue(iterator.next()==2);
		Assert.isTrue(iterator.next()==3);
		Assert.isTrue(iterator.next()==4);
	}

	@Test
	void testInsertionAtPosition() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertAtPosition(2,3);
		linkedList.insertAtPosition(1,0);
		linkedList.insertAtPosition(2,1);
		linkedList.insertAtPosition(3,2);
		linkedList.insertAtPosition(4,1);

		Iterator<Integer> iterator = linkedList.iterator();
		Assert.isTrue(iterator.next()==1);
		Assert.isTrue(iterator.next()==2);
		Assert.isTrue(iterator.next()==4);
		Assert.isTrue(iterator.next()==3);
	}

	@Test
	void testInsertion() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInFront(1);
		linkedList.insertInFront(2);
		linkedList.insertInFront(3);
		linkedList.insertInFront(4);

		linkedList.insertInEnd(5);
		linkedList.insertInEnd(6);
		linkedList.insertInEnd(7);

		linkedList.insertAtPosition(8,0);
		linkedList.insertAtPosition(9,1);
		linkedList.insertAtPosition(0,2);
		linkedList.insertAtPosition(-1,1);

		Iterator<Integer> iterator = linkedList.iterator();
		Assert.isTrue(iterator.next()==8);
		Assert.isTrue(iterator.next()==4);
		Assert.isTrue(iterator.next()==-1);
		Assert.isTrue(iterator.next()==9);
		Assert.isTrue(iterator.next()==0);
		Assert.isTrue(iterator.next()==3);
		Assert.isTrue(iterator.next()==2);
		Assert.isTrue(iterator.next()==1);
		Assert.isTrue(iterator.next()==5);
		Assert.isTrue(iterator.next()==6);
		Assert.isTrue(iterator.next()==7);
	}

	@Test
	void testDeleteElement() {
		LinkedList<Integer> linkedList = createLinkedList();

		Assert.isTrue(!linkedList.delete(10));
		Assert.isTrue(linkedList.delete(-1));

		Iterator<Integer> iterator = linkedList.iterator();
		Assert.isTrue(iterator.next()==8);
		Assert.isTrue(iterator.next()==4);
		Assert.isTrue(iterator.next()==9);
		Assert.isTrue(iterator.next()==0);
		Assert.isTrue(iterator.next()==3);
		Assert.isTrue(iterator.next()==2);
		Assert.isTrue(iterator.next()==1);
		Assert.isTrue(iterator.next()==5);
		Assert.isTrue(iterator.next()==6);
		Assert.isTrue(iterator.next()==7);
	}

	@Test
	void testDeleteElementAtPosition() {
		LinkedList<Integer> linkedList = createLinkedList();

		Assert.isTrue(!linkedList.deleteAtPosition(20));
		Assert.isTrue(!linkedList.deleteAtPosition(-1));
		Assert.isTrue(linkedList.deleteAtPosition(5));

		Iterator<Integer> iterator = linkedList.iterator();
		Assert.isTrue(iterator.next()==8);
		Assert.isTrue(iterator.next()==4);
		Assert.isTrue(iterator.next()==-1);
		Assert.isTrue(iterator.next()==9);
		Assert.isTrue(iterator.next()==0);
		Assert.isTrue(iterator.next()==2);
		Assert.isTrue(iterator.next()==1);
		Assert.isTrue(iterator.next()==5);
		Assert.isTrue(iterator.next()==6);
		Assert.isTrue(iterator.next()==7);
	}

	@Test
	void testSize() {
		LinkedList<Integer> linkedList = createLinkedList();

		Assert.isTrue(!linkedList.deleteAtPosition(20));
		Assert.isTrue(!linkedList.deleteAtPosition(-1));
		Assert.isTrue(linkedList.deleteAtPosition(5));
		Assert.isTrue(linkedList.size() == 10);
		Assert.isTrue(!linkedList.isEmpty());
	}

	@Test
	void testContains() {
		LinkedList<Integer> linkedList = createLinkedList();

		Assert.isTrue(!linkedList.contains(20));
		Assert.isTrue(linkedList.contains(-1));
	}

	@Test
	void testGetAtPosition() {
		LinkedList<Integer> linkedList = createLinkedList();

		Assert.isTrue(linkedList.getElementAtPosition(20)==null);
		Assert.isTrue(linkedList.getElementAtPosition(0)==8);
		Assert.isTrue(linkedList.getFirstElement()==8);
	}

	@Test
	void testIterable() {
		LinkedList<Integer> linkedList = createLinkedList();

		Iterator<Integer> iterator = linkedList.iterator();
		Assert.isTrue(iterator.next() == 8);
		Assert.isTrue(iterator.hasNext());
	}

	@Test
	void testClear() {
		LinkedList<Integer> linkedList = createLinkedList();
		linkedList.clear();
		Assert.isTrue(linkedList.isEmpty());
	}

	@Test
	void testPrintList() {
		LinkedList<Integer> linkedList = createLinkedList();
		linkedList.printElements();
	}

	private LinkedList<Integer> createLinkedList(){
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInFront(1);
		linkedList.insertInFront(2);
		linkedList.insertInFront(3);
		linkedList.insertInFront(4);
		linkedList.insertInEnd(5);
		linkedList.insertInEnd(6);
		linkedList.insertInEnd(7);
		linkedList.insertAtPosition(8,0);
		linkedList.insertAtPosition(9,1);
		linkedList.insertAtPosition(0,2);
		linkedList.insertAtPosition(-1,1);
		return linkedList;
	}
}
