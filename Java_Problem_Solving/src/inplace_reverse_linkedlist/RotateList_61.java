/**
 * 
 */
package inplace_reverse_linkedlist;

import org.junit.Test;

import inplace_reverse_linkedlist.ReverseSubList_LC92.ListNode;

/**
 * @author ramamurthy
 *
 */
public class RotateList_61 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode rotateRight_2(ListNode head, int k) {
		if (k == 0 || head == null || head.next == null) {
			return head;
		}
		
		int listLength = 1;
		ListNode originalTail = head;
		while(originalTail.next != null) {
			listLength++;
			originalTail = originalTail.next;
		}
		
		//Connect orginalLastNode to head and make it circular.
		originalTail.next = head;
		
		ListNode newHead = null;
		ListNode curr = head;
		ListNode prev = null;
		
		// Use Modulo to find the actual number of rotations required. 
		// Eg if k=4, and listLength=3 then #of rotations needed is 1.
		int rotations = k % listLength;
		// Skip listLength - rotations(k) -> (5 - 2) = 3. Skip 3 items then cut the link
		int skipLength = listLength - rotations;
				
		for(int i=1; i<=skipLength; i++) {
			prev = curr;
			curr = curr.next;
		}
		
		ListNode newTail = prev;
		newTail.next = null;
		newHead = curr;
		
		return newHead;
	}
	
	//Rotate entire list then rotate 1st section and 2nd section separately.
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0) {
			return head;
		}
		
		int size = 0;
		ListNode curr, prev, next, frontTail, segmentTail;
		prev = null;
		curr = head;
		next = null;
		
		//Rotate whole linked list
		while (curr != null) {
			next = curr.next;
			curr.next = prev; 
			prev = curr;
			curr = next;
			size++;
		}
		head = prev;
		
		//Rotate k nodes
		prev = null;
		curr = head;
		next = null;
		frontTail = prev;
		segmentTail = curr;
		for (int i=1; i <= k%size; i++) {
			next = curr.next;
			curr.next = prev; 
			prev = curr;
			curr = next;
		}
		head = prev;
		segmentTail.next = curr;
		
		frontTail = segmentTail;
		segmentTail = curr;
		while (curr != null) {
			next = curr.next;
			curr.next = prev; 
			prev = curr;
			curr = next;
		}
		frontTail.next = prev;
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
//	    head.next.next.next.next.next = new ListNode(6);

		ListNode result = rotateRight(head, 2);
		System.out.printf("Old Nodes of the reversed LinkedList for k = %d are : ", 3);
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
//	    head.next.next.next.next.next = new ListNode(6);

		ListNode result = rotateRight_2(head, 2);
		System.out.printf("New Nodes of the reversed LinkedList for k = %d are : ", 3);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println("\n");
	}
}
