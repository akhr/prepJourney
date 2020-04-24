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
public class PeakIndexInMountainArray_852 {

	public int peakIndexInMountainArray(int[] a) {
		int left=0, right=a.length-1;
		while(left < right) {
			int mid = left + (right-left)/2;
			
			if (a[mid] > a[mid+1]) { //we are in descending side. peak can be mid or before mid.
				right = mid;
			}else { // we are in ascending side. Peak will be after mid only.
				left = mid+1;
			}
		}
		return a[left]; // at the end of the while loop, 'start == end'
	}
	
	@Test
	public void test_01() {
		int[] arr = new int[] {1, 3, 8, 12, 4, 2};
		int res = 12;
		assertEquals(res, peakIndexInMountainArray(arr));
	}

}

/**
 * Problem Statement #
Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Example 1:

Input: [1, 3, 8, 12, 4, 2]
Output: 12
Explanation: The maximum number in the input bitonic array is '12'.
Example 2:

Input: [3, 8, 3, 1]
Output: 8
Example 3:

Input: [1, 3, 8, 12]
Output: 12
Example 4:

Input: [10, 9, 8]
Output: 10
Try it yourself #
*/