package dp.partitionEqualSubsetSum;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BruteForce {
	
	static int COUNTER = 0;

	public boolean canPartition(int[] nums) {
		System.out.println("======================");
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}
		if (totalSum%2 != 0) {
			return false;
		}
		
		int target = totalSum/2;
		
		boolean res = recurse(nums, target, 0);
		System.out.println("======================");
		return res;
	}
	
	public boolean recurse(int[] nums, int target, int currIndex) {
		if (currIndex >= nums.length || target < 0) {
			return false;
		}
		if (target == 0) {
			return true;
		}
		
		COUNTER++;
		
		boolean includeResult = false;
		if (nums[currIndex] <= target) {
			int newTarget = target - nums[currIndex];
			includeResult = recurse(nums, newTarget, currIndex+1);
		}
		if (includeResult) {
			System.out.println("Choose - "+nums[currIndex]);
		}
		boolean excludeResult = recurse(nums, target, currIndex+1);
		return includeResult || excludeResult;
	}
	
	@Before
	public void prepare() {
		COUNTER=0;
	}
	
	@Test
	public void Test_01() {
		int[] nums = {1, 2, 3, 4};
//		COUNTER=0;
		assertTrue(canPartition(nums));
		System.out.println("Test_01 COUNTER - "+COUNTER);
	}
	
	@Test
	public void Test_02() {
		int[] nums = {1, 5, 11, 5};
//		COUNTER=0;
		assertTrue(canPartition(nums));
		System.out.println("Test_02 COUNTER - "+COUNTER);
	}

	@Test
	public void Test_03() {
		int[] nums = {2, 3, 4, 6};
//		COUNTER=0;
		assertFalse(canPartition(nums));
		System.out.println("Test_03 COUNTER - "+COUNTER);
	}

}
