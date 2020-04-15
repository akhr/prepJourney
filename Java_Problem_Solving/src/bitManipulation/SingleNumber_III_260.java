/**
 * 
 */
package bitManipulation;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class SingleNumber_III_260 {
	public int[] singleNumber(int[] nums) {
		if (nums.length <= 1) {
			return new int[]{};
		}
		if (nums.length == 2) {
			return nums;
		}
		
		int xor = 0;
		for (int num : nums) {
			xor ^= num;
		}
		
		int rightmostBitSet = 1;
		while ((rightmostBitSet & xor) == 0) {
			rightmostBitSet = rightmostBitSet << 1; 
		}
		
		int grp1Xor = 0;
		int grp2Xor = 0;
		for (int num : nums) {
			if ((rightmostBitSet & num) == 0) {
				grp1Xor ^= num;
			}else {
				grp2Xor ^= num;
			}
		}
		return new int[]{grp1Xor, grp2Xor};
	}
	
	
	@Test
	public void test_01(){
		int[] nums = new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
		int[] expecteds = new int[]{4, 6};
		assertArrayEquals(expecteds, singleNumber(nums));
	}
}
