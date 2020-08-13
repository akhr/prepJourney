package slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MaximumSizeSubarraySumEqualsK_325 {

	public int maxSubArrayLen(int[] nums, int k) {
		if (nums.length == 0) return 0;
		
		//prefix sum
		for(int i=1; i<nums.length; i++){
			nums[i] += nums[i-1];
		}
		
		// prefixSum[j] - prefixSum[i] = k
		// we find to prefix[j] - k exist in the map.
		Map<Integer, Integer> map = new HashMap<>(); //key = sum, val = index (nums[0]->nums[i] add up to make the sum. store i in map) 
		map.put(0, -1);
		int sum = 0;
		int maxLen = 0;
		for(int j = 0; j<nums.length; j++) {
			sum = nums[j];
			if(map.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, j - map.get(sum - k));
			}
			map.putIfAbsent(sum, j); // keep only 1st duplicate as we want first index as left as possible
		}
		return maxLen;
	}
	
	@Test
	public void test_01() {
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		int expected = 4;
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
	
	@Test
	public void test_02() {
		int[] nums = {-2, -1, 2, 1};
		int k = 1;
		int expected = 2;
		assertEquals(expected, maxSubArrayLen(nums, k));
	}

}
