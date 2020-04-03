/**
 * 
 */
package bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;

/**
 * @author ramamurthy
 *
 */
public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int res = 0;
		for (int num : nums){
			res ^= num;
		}
		return res;
	}

	@Test
	public void Test_01() {
		int[] in = {2,2,1};
		int expected = 1;
		assertEquals(expected, singleNumber(in));
	}
	
	@Test
	public void Test_02() {
		int[] in = {4,1,2,1,2};
		int expected = 4;
		assertEquals(expected, singleNumber(in));
	}
	
	@Test
	public void Test_03() {
		int[] in = {100};
		int expected = 100;
		assertEquals(expected, singleNumber(in));
	}
}
