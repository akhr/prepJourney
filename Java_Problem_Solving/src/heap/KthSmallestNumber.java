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
				return o2 - o1;
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
		int[] nums = new int[]{1, 5, 12, 2, 11, 5};
		int k = 3;
		int expected = 5;
		assertEquals(expected, findKthSmallestNumber(nums, k));
	}
	
	@Test
	public void test_02() {
		int[] nums = new int[]{1, 5, 12, 2, 11, 6};
		int k = 4;
		int expected = 6;
		assertEquals(expected, findKthSmallestNumber(nums, k));
	}
	
	@Test
	public void test_03() {
		int[] nums = new int[]{5, 12, 11, -1, 12};
		int k = 3;
		int expected = 11;
		assertEquals(expected, findKthSmallestNumber(nums, k));
	}

}
