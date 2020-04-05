/**
 * 
 */
package two_pointers;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class MoveZeros_283 {
	
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
		while (j < nums.length) {
			if (nums[j] != 0) {
				nums[i] = nums[j];
				i++;
			}
			j++;
		}
		
		Arrays.fill(nums, i, nums.length, 0);
    }

	public void moveZeroes_02(int[] nums) {
		for (int lastNonZeroIndx = 0, curr = 0; curr < nums.length; curr++) {
			if (nums[curr] != 0) {
				swap(nums, curr, lastNonZeroIndx);
				lastNonZeroIndx++;
			}
		}
	}

	private void swap(int[]nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b]; 
		nums[b] = temp;
	}

	@Test
	public void Test_01() {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		int[] expected = {1,3,12,0,0};
		assertArrayEquals(expected, nums);
	}
	
	@Test
	public void Test_02() {
		int[] nums = {1,0};
		moveZeroes(nums);
		int[] expected = {1,0};
		assertArrayEquals(expected, nums);
	}
	
	@Test
	public void Test_03() {
		int[] nums = {0,1};
		moveZeroes(nums);
		int[] expected = {1,0};
		assertArrayEquals(expected, nums);
	}

}
