/**
 * 
 */
package linkedlist.inplace_reverse_linkedlist;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class ReverseNodeInAlternateKGroup {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode reverseKAltGroup(ListNode head, int k) {
		if (head == null || k <= 0) {
			return head;
		}

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		ListNode frontTail = prev;
		ListNode segmentTail = curr;

		//To run for every K sized group until we run out of nodes
		while(curr != null) {
			frontTail = prev;
			segmentTail = curr;
			
				for(int i=1; i<=k && curr!= null; i++) {
					next =curr.next;
					curr.next = prev;
					prev = curr;
					curr = next;
				}
				if(frontTail != null) {
					frontTail.next = prev;
				}else {
					head = prev;
				}
				segmentTail.next = curr;
				
				//skip next k items
				for(int i=1; i<=k && curr!= null; i++) {
					prev = curr;
					curr = curr.next;
				}
		}
		return head;
	}

	@Test
	public void Test_01() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = reverseKAltGroup(head, 3);
		System.out.printf("Nodes of the reversed LinkedList for k = %d are : ", 3);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println("\n");
	}
	
	@Test
	public void Test_02() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = reverseKAltGroup(head, 2);
		System.out.printf("Nodes of the reversed LinkedList for k = %d are : ", 2);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}


}
