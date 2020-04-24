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
public class MinimumDifferenceElement {

	public static int searchMinDiffElement(int[] arr, int key) {
		int left = 0, right = arr.length-1;
		
		while(left <= right) {
			int mid = left + (right - left)/2;

			// if k == arr[mid] the return min of k-a[mid-1] and a[mid+1]-k
			if(key == arr[mid]) {
				return key-arr[mid-1] < arr[mid+1]-key ? arr[mid-1] : arr[mid+1];
			}
			
			if (key < arr[mid]) {
				// if k < arr[mid] the return min of k-a[mid-1] and a[mid]-k
				if(arr[mid-1] < key) {
					return key-arr[mid-1] < arr[mid]-key ? arr[mid-1] : arr[mid];
				}else {
					right = mid-1;
				}
			}else {
				// if k > arr[mid] the return min of k-a[mid] and a[mid+1]-k
				if( key < arr[mid+1]) {
					return key-arr[mid] < arr[mid+1]-key ? arr[mid] : arr[mid+1];
				}else {
					left = mid+1;
				}
			}
		}
		return -1;
	}
	
	@Test
	public void test_01() {
		int[] arr = new int[] {4, 6, 10};
		int key = 7, res = 6;
		assertEquals(res, searchMinDiffElement(arr, key));
	}
	
	@Test
	public void test_02() {
		int[] arr = new int[] {1, 3, 8, 10, 15};
		int key = 12, res = 10;
		assertEquals(res, searchMinDiffElement(arr, key));
	}

}
