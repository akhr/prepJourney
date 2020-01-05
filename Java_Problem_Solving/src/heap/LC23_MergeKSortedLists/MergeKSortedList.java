/**
 * @fileName: MergeKSortedList.java
 * @author: ramamurthy
 * @CreatedOn: Jan 5, 2020
 * 
 */
package heap.LC23_MergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
 * @fileName: MergeKSortedList.java
 * @author: ramamurthy
 * @Created on: Jan 5, 2020
 * 
 */
public class MergeKSortedList {

	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		if (k == 0) {
			return null;
		}
		
		Queue<ListNode> q = new PriorityQueue<ListNode>(k, comp);
		for (ListNode h : lists){
			if (h != null)
				q.add(h);
			
		}

		ListNode rHead = null;
		ListNode rTail = null;
		while(!q.isEmpty()){
			ListNode a = q.poll();

			if (a.next != null){
				q.add(a.next);
			}

			if (rHead == null){
				rHead = a;
				rTail = a;
			}else{
				rTail.next = a;
				rTail = a;
			}
		}
		return rHead;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x, ListNode next) { 
			val = x; 
			this.next = next;
		}
	}
	
	Comparator<ListNode> comp = new Comparator<ListNode>() {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			if (o1.val > o2.val) {
				return 1;
			} else if (o1.val < o2.val) {
				return -1;
			}
			return 0;
		}
	};
	
	@Test
	public void Test_0() {
		ListNode a = new ListNode(1, new ListNode(4, new ListNode(5, null)));
		ListNode b = new ListNode(1, new ListNode(3, new ListNode(4, null)));
		ListNode c = new ListNode(2, new ListNode(6, null));
		
		ListNode[] ll = new ListNode[]{a,b,c};
		ListNode res = mergeKLists(ll);
		
		ListNode curr = res;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
	
	@Test
	public void Test_1() {
		ListNode a = new ListNode(5, new ListNode(7, new ListNode(10, new ListNode(12, new ListNode(16, null)))));
		ListNode b = new ListNode(-1, new ListNode(0, new ListNode(1, new ListNode(13, new ListNode(18, null)))));
		ListNode c = new ListNode(15, new ListNode(20, null));
		ListNode d = new ListNode(2, new ListNode(3, new ListNode(6, null)));
		
		ListNode[] ll = new ListNode[]{a,b,c,d};
		ListNode res = mergeKLists(ll);
		
		ListNode curr = res;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
	
	@Test
	public void Test_2() {
		ListNode a = new ListNode(1, new ListNode(4, new ListNode(5, null)));
		ListNode b = null;
		ListNode c = new ListNode(2, new ListNode(6, null));
		
		ListNode[] ll = new ListNode[]{a,b,c};
		ListNode res = mergeKLists(ll);
		
		ListNode curr = res;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
	
	@Test
	public void Test_3() {
		ListNode a = null;
		ListNode b = null;
		ListNode c = null;
		
		ListNode[] ll = new ListNode[]{a,b,c};
		ListNode res = mergeKLists(ll);
		
		ListNode curr = res;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
	
	@Test
	public void Test_4() {
		ListNode[] ll = new ListNode[]{};
		ListNode res = mergeKLists(ll);
		
		ListNode curr = res;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
}
