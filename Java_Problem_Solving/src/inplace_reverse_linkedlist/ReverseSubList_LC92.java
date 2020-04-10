package inplace_reverse_linkedlist;

import org.junit.Test;

public class ReverseSubList_LC92 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		
		ListNode prev, curr;
		prev = null;
		curr = head;
		
		for (int i=1; i<m && curr != null; i++) {
			prev = curr;
			curr = curr.next;
		}
		
		ListNode frontTail = prev;
		ListNode segmentTail = curr;
		ListNode next;
		
		for (int i=m; i < n+1 && curr != null; i++) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		if (frontTail != null) {
			frontTail.next = prev;
		}else {
			head = prev;
		}
		
		segmentTail.next = curr;
		return head;
	}
	
	@Test
	public void Test_01() {
	    ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);

	    ListNode result = reverseBetween(head, 2, 4);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.val + " ");
	      result = result.next;
	    }
	    System.out.println();
	  }
	
	@Test
	public void Test_02() {
	    ListNode head = new ListNode(1);
	    head.next = new ListNode(5);

	    ListNode result = reverseBetween(head, 1, 2);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.val + " ");
	      result = result.next;
	    }
	    System.out.println();
	  }
}

