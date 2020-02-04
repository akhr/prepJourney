package linkedlist;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ReverseSinglyLinkedList {

	public static class Node {
		private String data;
		private Node next;
		
		public Node(String d, Node n) {
			this.data = d;
			this.next = n;
		}
	}

	public Node reverse(Node head) {
		Node prev, curr, next;
		prev = null;
		curr = head;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	@Test
	public void Test_1(){
		Node head = new Node("1", new Node("2", new Node("3", new Node("4", null))));
		Node curr = head;
		while(curr != null) {
			System.out.printf("%s --> ", curr.data);
			curr = curr.next;
		}
		Node reversed = reverse(head);
		assertNotNull(reversed);
		curr = reversed;
		System.out.println();
		while(curr != null) {
			System.out.printf("%s --> ", curr.data);
			curr = curr.next;
		}
	}
}
