/**
 * 
 */
package general;

import linkedlist.ReverseNodeInAlternateKGroup.ListNode;

/**
 * @author ramamurthy
 *
 */
public class MinStack {

	public class ListNode {
		int val;
		ListNode next;
		int minVal;
		ListNode(int x) { val = x; }
	}

	/** initialize your data structure here. */
	ListNode head;
	ListNode tail;

	public MinStack() {
		head = null;
		tail = null;
	}

	public void push(int x) {
		ListNode newNode = new ListNode(x);
		newNode.next = head;
		if (head == null || (head != null && head.minVal > x)) {
			newNode.minVal = x;
		} else {
			newNode.minVal = head.minVal;
		}
		head = newNode;
	}

	public void pop() {
		if (head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = null;
		}
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.minVal;
	}
}
