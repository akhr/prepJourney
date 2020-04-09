/**
 * 
 */
package dp.partitionEqualSubsetSum;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class DP_Bottom_Up {

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

		//Declare cache
		Boolean[][] dp = new Boolean[nums.length][target+1];
		// Load base cases into cache
		for(int item=0; item < nums.length; item++) {
			dp[item][0] = true;
		}
		for(int t=1; t<=target; t++) {
			if(nums[0] == t) {
				dp[0][t] = true;
			}else {
				dp[0][t] = false;
			}
		}

		// Find answers for other cells in the matrix (non-basecases) uses basecases
		for(int i=1; i<nums.length; i++) {
			for(int t=1; t<=target; t++) {
				COUNTER++;
				boolean includedRes = false;
				//include the item and check if it can make the target=0 along with other 1st `i` items.
				if (nums[i] <= t) {
					int newT = t - nums[i];
					includedRes = (newT == 0) || dp[i-1][newT];
				}
				//exclude the item. Check if pervious item can make the target=0
				boolean excludesRes = dp[i-1][t];
				dp[i][t] = includedRes || excludesRes;
			}
		}
		return dp[nums.length-1][target];
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
	
	@Test
	public void Test_04() {
		int[] nums = {2, 6, 4, 6};
		assertFalse(canPartition(nums));
		System.out.println("Test_04 COUNTER - "+COUNTER);
	}

}
