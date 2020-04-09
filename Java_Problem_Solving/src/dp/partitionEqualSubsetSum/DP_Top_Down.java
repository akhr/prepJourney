package dp.partitionEqualSubsetSum;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DP_Top_Down {
	
	static int COUNTER = 0;
	
	public boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}
		if(totalSum%2 != 0) {
			return false;
		}
		int target = totalSum/2;
		
		Boolean[][] dp = new Boolean[nums.length][target+1];
		
		return recurse(nums, target, 0, dp);
	}
	
	private static boolean recurse(int[] nums, int target, int currIndex, Boolean[][] dp) {
		if (target == 0) {
			return true;
		}
		if (currIndex == nums.length || target < 0) {
			return false;
		}
		
		if (dp[currIndex][target] != null) {
			return dp[currIndex][target];
		}
		
		COUNTER++;
		boolean includedRes = false;
		if (nums[currIndex] <= target) {
			int newTarget = target - nums[currIndex];
			includedRes = recurse(nums, newTarget, currIndex+1, dp);
		}
		boolean excludedRes = recurse(nums, target, currIndex+1, dp);
		
		boolean res = includedRes || excludedRes;
		dp[currIndex][target] = res;
		return res;
	}
	
	@Before
	public void prepare() {
		COUNTER=0;
	}
	
	@Test
	public void Test_01() {
		int[] nums = {1, 2, 3, 4};
		assertTrue(canPartition(nums));
		System.out.println("Test_01 COUNTER - "+COUNTER);
	}
	
	@Test
	public void Test_02() {
		int[] nums = {1, 5, 11, 5};
		assertTrue(canPartition(nums));
		System.out.println("Test_02 COUNTER - "+COUNTER);
	}

	@Test
	public void Test_03() {
		int[] nums = {2, 3, 4, 6};
		assertFalse(canPartition(nums));
		System.out.println("Test_03 COUNTER - "+COUNTER);
	}

}
