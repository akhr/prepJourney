package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumSubArrayOfSizeK {
	
	/*
	 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
	 * 
	 * Input: [2, 1, 5, 1, 3, 2], k=3 
	 * Output: 9
	 * Explanation: Subarray with maximum sum is [5, 1, 3].
	 */

	public static int findMaxSumSubArray(int k, int[] arr) {
		if (k==0 || arr.length == 0) {
			return -1;
		} 
		if(arr.length == 1) {
			return arr[0];
		}

		int maxSum = Integer.MIN_VALUE;
		int windowStart, windowEnd, windowSum;
		windowStart = windowEnd = windowSum = 0;
		
		while(windowEnd < arr.length) {
			//expand window
			while(windowEnd - windowStart < k) {
				windowSum += arr[windowEnd];
				windowEnd++;
			}
			
			maxSum = Math.max(maxSum, windowSum);
			//slide window
			windowSum -= arr[windowStart];
			windowStart++;
		}
		return maxSum;
	}
	
	@Test
	public void Test_01() {
		int[] arr = {2, 1, 5, 1, 3, 2};
		int k = 3;
		int expected = 9;
		Assert.assertEquals(expected, findMaxSumSubArray(k , arr));
	}
	
	@Test
	public void Test_02() {
		int[] arr = {2, 3, 4, 1, 5};
		int k = 2;
		int expected = 7;
		Assert.assertEquals(expected, findMaxSumSubArray(k , arr));
	}
}
