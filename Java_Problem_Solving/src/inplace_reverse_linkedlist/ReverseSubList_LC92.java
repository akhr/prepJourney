package inplace_reverse_linkedlist;

import org.junit.Test;

public class ReverseSubList_LC92 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseBetween_2(ListNode head, int m, int n) {
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
		
		int i = m;
		while(i < n+1 && curr  != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			i++;
		}
		
		if (frontTail != null) {
			frontTail.next = prev;
		}else {
			head = prev;
		}
		
		segmentTail.next = curr;
		return head;
	}
	

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
		      return head;
		
		ListNode prev, curr, segHead, segTail, frontTail, rearHead;
		prev = null;
		curr = head;
		int a = 1;
		
		while(a < m-1 && curr != null) {
			prev = curr;
			curr = curr.next;
			a++;
		}
		
		frontTail = prev;
		segHead = curr;
		segTail = curr;
		
		while(a < n) {
			curr = curr.next;
			a++;
		}
		rearHead = curr.next;
		
		//cut the links
		segTail.next = null;
		ListNode[] reversed = reverse(segHead);
		
		//assemble back
		if(frontTail != null)
			frontTail.next = reversed[0];
		else
			head = reversed[0];
		
		reversed[1].next = rearHead;
		
		return head;
	}
	
	private ListNode[] reverse(ListNode head) {
		ListNode prev, curr, next;
		prev = null;
		curr = head;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return new ListNode[]{prev, head};
	}
	
	@Test
	public void Test_01() {
	    ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);

	    ListNode result = reverseBetween_2(head, 2, 4);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.val + " ");
	      result = result.next;
	    }
	  }
	
	@Test
	public void Test_02() {
	    ListNode head = new ListNode(1);
	    head.next = new ListNode(5);

	    ListNode result = reverseBetween_2(head, 1, 2);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.val + " ");
	      result = result.next;
	    }
	  }
}

