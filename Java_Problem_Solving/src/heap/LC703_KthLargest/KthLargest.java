package heap.LC703_KthLargest;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
	Queue<Integer> q = new PriorityQueue<>();
	int k;
	
	public KthLargest(int k, int[] nums) {
		this.k = k;
		for(int i : nums) {
			add(i);
		}
	}

	public int add(int val) {
		if (q.size() < this.k) {
			q.offer(val);
		}else if (val > q.peek()) {
			q.poll();
			q.offer(val);
		}
		return q.peek();
	}
}