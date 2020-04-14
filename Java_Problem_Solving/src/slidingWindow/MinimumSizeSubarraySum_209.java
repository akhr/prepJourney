package slidingWindow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;

public class MinimumSizeSubarraySum_209 {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int left, right, minLen, sum;
		left = right = sum = 0;
		minLen = Integer.MAX_VALUE;

		while(right < nums.length) {
			//expand window
			while(sum < s && right < nums.length) {
				sum += nums[right];
				right++;
			}

			if (sum >= s) {
				minLen = Math.min(minLen, right - left);
			}

			//shrink window
			while(sum >= s) {
				sum -= nums[left];
				left++;
				if (sum >= s) {
					minLen = Math.min(minLen, right - left);
				}
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	@Test
	public void Test_01() {
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		int expected = 2;
		assertEquals(expected, minSubArrayLen(s, nums));
	}

	@Test
	public void Test_02() {
		int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
		int s = 213;
		int expected = 8;
		assertEquals(expected, minSubArrayLen(s, nums));
	}

	@Test
	public void Test_03() {
		int[] nums = {1,1};
		int s = 3;
		int expected = 0;
		assertEquals(expected, minSubArrayLen(s, nums));
	}

}
