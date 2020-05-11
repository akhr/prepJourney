/**
 * @authour Akhash Ramamurthy
 */
package dp.rangeSum_303;

/**
 * @author Akhash Ramamurthy
 *
 */
public class DP_Bottom_Up {
	int[] data;
	int[] cache;
	public DP_Bottom_Up(int[] nums) {
		this.data = nums;
		cache = new int[nums.length];
		if (nums.length == 0) return; //for empty array.

		cache[0] =  nums[0];
		for(int i=1; i<nums.length; i++) {
			cache[i] = cache[i-1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		if(i == 0) 
			return cache[j];
		return cache[j] - cache[i-1];
	}
}
