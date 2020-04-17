package heap;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class LC_215_KthLargestElementInArray {
	public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(k);
        
        for(int i=0; i<nums.length; i++){
            if (q.size() < k){
                q.offer(nums[i]);
                continue;
            }
            if(nums[i] > q.peek()){
                q.poll();
                q.offer(nums[i]);
            }
        }
        return q.peek();  
    }
	
	@Test
	public void test_01() {
		int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
		int expected = 4;
		assertEquals(expected, findKthLargest(nums, 4));
	}
	
	@Test
	public void test_02() {
		int[] nums = new int[]{3,2,1,5,6,4};
		int expected = 5;
		assertEquals(expected, findKthLargest(nums, 2));
	}
}
