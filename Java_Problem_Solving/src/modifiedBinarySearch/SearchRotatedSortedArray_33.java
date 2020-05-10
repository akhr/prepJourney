/**
 * @authour Akhash Ramamurthy
 */
package modifiedBinarySearch;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Akhash Ramamurthy
 *
 */
public class SearchRotatedSortedArray_33 {

	public int search(int[] nums, int target) {
		if(nums.length == 0) return -1;
		
		int left = 0, right = nums.length-1;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if (nums[mid] == target) return mid;
			
			if(nums[mid] >= nums[left]) { //If yes, then search in non-rotated section of the i/p.
				if(target >= nums[left] && target < nums[mid]){
					right = mid-1;
				}else {
					left = mid+1;
				}
			}else { //If no, then search in rotated section of the i/p.
				if(target > nums[mid] && target <= nums[right]) {
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
		}
		return -1;
	}
	
	@Test
	public void test_01(){
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		int expected = 4;
		assertEquals(expected, search(nums, target));
	}
	
	@Test
	public void test_02(){
		int[] nums = {4,5,6,7,0,1,2};
		int target = 3;
		int expected = -1;
		assertEquals(expected, search(nums, target));
	}
	
	@Test
	public void test_03(){
		int[] nums = {3,1};
		int target = 1;
		int expected = 1;
		assertEquals(expected, search(nums, target));
	}

}
