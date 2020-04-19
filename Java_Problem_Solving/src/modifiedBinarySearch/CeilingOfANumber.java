/**
 * 
 */
package modifiedBinarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 *         Given an array of numbers sorted in an ascending order, find the ceiling of a given
 *         number ‘key’. The ceiling of the ‘key’ will be the smallest element in the given array
 *         greater than or equal to the ‘key’. Write a function to return the index of the ceiling
 *         of the ‘key’. If there isn’t any ceiling return -1. 
 * 		   Example 1: Input: [4, 6, 10], key = 6
 *         Output: 1 Explanation: The smallest number greater than or equal to '6' is '6' having
 *         index '1'.
 */
public class CeilingOfANumber {
	
	public static int searchCeilingOfANumber(int[] a, int k) {
		if (a.length == 0) return -1;
		int n = a.length-1;
			return helper(a, 0, n, k);
	}
	
	private static int helper(int[] a, int left, int right, int k) {
		if (left > right) 
			return -1;
		if(k < a[left]) {
			return left;
		}
		
		int mid = left + (right-left)/2;
		if (k == a[mid]) 
			return mid;
		else if (k > a[mid]) {
			return helper(a, mid+1, right, k);
		}else {
			return helper(a, left, mid-1, k);
		}
 	}
	
	@Test
	public void test_01() {
		int[] a = {1, 3, 8, 10, 15};
		int k = 12;
		int expected = 4;
		assertEquals(expected, searchCeilingOfANumber(a,k));
	}
	
	@Test
	public void test_02() {
		int[] a = {4, 6, 10};
		int k = 6;
		int expected = 1;
		assertEquals(expected, searchCeilingOfANumber(a,k));
	}
	
	@Test
	public void test_03() {
		int[] a = {4, 6, 10};
		int k = 17;
		int expected = -1;
		assertEquals(expected, searchCeilingOfANumber(a,k));
	}
	
	@Test
	public void test_04() {
		int[] a = {4, 6, 10};
		int k = -1;
		int expected = 0;
		assertEquals(expected, searchCeilingOfANumber(a,k));
	}
	
	@Test
	public void test_05() {
		int[] a = {};
		int k = 0;
		int expected = -1;
		assertEquals(expected, searchCeilingOfANumber(a,k));
	}

}
