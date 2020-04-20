/**
 * 
 */
package modifiedBinarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class SearchSortedArrayOfUnknownSize_702 {

	class ArrayReader {
		int[] arr;

		ArrayReader(int[] arr) {
			this.arr = arr;
		}

		public int get(int index) {
			if (index >= arr.length)
				return Integer.MAX_VALUE;
			return arr[index];
		}
	}

	public int search(ArrayReader reader, int target) {
		int left = 0, right = 1;
		while(reader.get(right) < target) {
			right = right*2;
		}
		while (reader.get(right) == -1) { //Shrink if we go beyond actual size.
			right--;
		}

		while(left <= right) {
			int mid = left + (right-left)/2;
			if(target < reader.get(mid)) right = mid-1;
			else if (target > reader.get(mid)) left = mid+1;
			else return mid;
		}
		return -1;
	}


	@Test
	public void test_01() {
		ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
		int k = 16;
		int expected = 6;
		assertEquals(expected, search(reader, k));
	}
	
	@Test
	public void test_02() {
		ArrayReader reader = new ArrayReader(new int[] { -1,0,3,5,9,12 });
		int k = 9;
		int expected = 4;
		assertEquals(expected, search(reader, k));
	}
}
