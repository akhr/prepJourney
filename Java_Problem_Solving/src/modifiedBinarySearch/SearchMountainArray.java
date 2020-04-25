/**
 * @authour Akhash Ramamurthy
 */
package modifiedBinarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class SearchMountainArray {
	public static int search(int[] a, int k) {
		int l = 0, r = a.length-1;
		while(l <= r) {
			int m = l + (r-l)/2;
			if(k == a[m]) return m;
			if (m == a.length-1) return -1; //If m == last node then m+1 is out of bound
			if(a[m] > a[m+1]) {
				//desc slope
				if(k > a[m]) r = m-1;
				else l = m+1;
			}else {
				//asc slope
				if(k > a[m]) l = m+1;
				else r = m-1;
			}
		}
		return -1;
	}
	
	@Test
	public void test_01() {
		int[] arr = new int[] {1, 3, 8, 4, 3};
		int k = 4, res = 3;
		assertEquals(res, search(arr, k));
	}
	
	@Test
	public void test_02() {
		int[] arr = new int[] {3, 8, 3, 1};
		int k = 8, res = 1;
		assertEquals(res, search(arr, k));
	}
	
	@Test
	public void test_03() {
		int[] arr = new int[] {1, 3, 8, 12};
		int k = 12, res = 3;
		assertEquals(res, search(arr, k));
	}
	
	@Test
	public void test_04() {
		int[] arr = new int[] {10,9,8};
		int k = 10, res = 0;
		assertEquals(res, search(arr, k));
	}
	
	@Test
	public void test_05() {
		int[] arr = new int[] {};
		int k = 10, res = -1;
		assertEquals(res, search(arr, k));
	}
	
	@Test
	public void test_06() {
		int[] arr = new int[] {1, 3, 8, 12};
		int k = 23, res = -1;
		assertEquals(res, search(arr, k));
	}
}
