/**
 * 
 */
package modifiedBinarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author ramamurthy
 *	
 */
public class BinarySearch_704 {
	
	private enum ORDER{
		ASC,
		DESC,
	}

	public static int search(int[] a, int k) {
		if (a.length == 0) return -1;
		int n = a.length-1;
		if (a[0] < a[n]) 
			return helper(a, 0, n, ORDER.ASC, k);
		else
			return helper(a, 0, n, ORDER.DESC, k);
	}
	
	private static int helper(int[] a, int left, int right, ORDER order, int k) {
		if (left > right) return -1;
		int mid = left + (right-left)/2;
		if (a[mid] == k) 
			return mid;
		if (k < a[mid]) 
			return order == ORDER.ASC ? helper(a, left, mid-1, ORDER.ASC, k) : helper(a, mid+1, right, order.DESC, k);
		else 
			return order == ORDER.ASC ? helper(a, mid+1, right, ORDER.ASC, k) : helper(a, left, mid-1, ORDER.DESC, k);
 	}
	
	@Test
	public void test_01() {
		int[] a = {1, 2, 3, 4, 5, 6, 7 };
		int k = 5;
		int expected = 4;
		assertEquals(expected, search(a,k));
	}
	
	@Test
	public void test_02() {
		int[] a = {10, 6, 4 };
		int k = 10;
		int expected = 0;
		assertEquals(expected, search(a,k));
	}
	
	@Test
	public void test_03() {
		int[] a = {10, 6, 4 };
		int k = 4;
		int expected = 2;
		assertEquals(expected, search(a,k));
	}
	

}
