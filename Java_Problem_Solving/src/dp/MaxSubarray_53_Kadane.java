package dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSubarray_53_Kadane {

	public int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return 0;

		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];
		for (int i=1; i<nums.length; i++) {
			/*
	        We are inspecting the item at index i.
			We want to answer the question:
		        "What is the Max Contiguous Subarray Sum we can achieve ending at index i?"
		        
		        We have 2 choices:
		        maxEndingHere + nums[i] (extend the previous subarray best whatever it was)
		        
		          1.) Let the item we are sitting at contribute to this best max we achieved
		          ending at index i - 1.
		        nums[i] (start and end at this index)
		        
		          2.) Just take the item we are sitting at's value.
		        The max of these 2 choices will be the best answer to the Max Contiguous
		        Subarray Sum we can achieve for subarrays ending at index i.
			 */
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}	

	@Test
	public void Test_01() {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int expected = 6;
		assertEquals(expected, maxSubArray(nums));
	}

	@Test
	public void Test_02() {
		int[] nums = {};
		int expected = 0;
		assertEquals(expected, maxSubArray(nums));
	}

	@Test
	public void Test_03() {
		int[] nums = {-1, -2};
		int expected = -1;
		assertEquals(expected, maxSubArray(nums));
	}

	@Test
	public void Test_04() {
		int[] nums = {-1};
		int expected = -1;
		assertEquals(expected, maxSubArray(nums));
	}

}
