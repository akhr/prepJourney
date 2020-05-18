/**
 * 
 */
package linkedlist.inplace_reverse_linkedlist;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class ReverseNodeInKGroup {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	//Very similar to ReeverseSubList_92 with 2 changes marked with comments below.
	public ListNode reverseKGroup(ListNode head, int k) {
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
			
			//Find if we got enough nodes
			ListNode grpCurr = curr;
			int grpLen = 0;
			while (grpLen<k && grpCurr!= null) {
				grpCurr = grpCurr.next;
                grpLen++;
			}
			if (grpLen !=k) {
				break;
			}
			
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
			
			//Prepare for next K sized group.
			frontTail = segmentTail;
			segmentTail = curr;
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

	    ListNode result = reverseKGroup(head, 3);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.val + " ");
	      result = result.next;
	    }
	}

}
