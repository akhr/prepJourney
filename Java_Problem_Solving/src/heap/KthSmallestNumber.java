package heap;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class KthSmallestNumber {

	public static int findKthSmallestNumber(int[] nums, int k) {
		Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for (int i=0; i<nums.length; i++) {
			if (i < k) {
				q.add(nums[i]);
				continue;
			}
			if(nums[i] < q.peek()) {
				q.poll();
				q.add(nums[i]);
			}
		}
		return q.peek();
	}
	
	@Test
	public void test_01() {
		int[] nums = new int[]{3,2,3,1,2,4,5,5,6,-1,-2,-54,200, 40,-55};
		int expected = -55;
		assertEquals(expected, findKthSmallestNumber(nums, 4));
	}

}
