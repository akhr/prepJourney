/**
 * @authour Akhash Ramamurthy
 */
package merge_interval;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class MergeIntervals_56 {
	
	// T(N) = O(NlogN) --> O(NlogN) for sorting + O(N) rot run thro sorted list and merging
	// S(N) = O(N) --> for Sorting. If in-place sorting is used then O(1)

	public int[][] merge(int[][] intervals) {
		if (intervals.length < 2) return intervals;

		Arrays.sort(intervals, (int[] a, int[] b) ->  Integer.compare(a[0], b[0]));

		LinkedList<int[]> merged = new LinkedList<>();
		for(int[] currInterval : intervals) {
			if(merged.isEmpty() || merged.getLast()[1] < currInterval[0]) {
				merged.add(currInterval);
			}else { // overlapping - two intervals merged into one
				int[] a = merged.getLast();
				int[] b = currInterval;
				a[1] = Math.max(a[1], b[1]);
			}
		}
		return merged.toArray(new int[merged.size()][2]);
	}

	@Test
	public void test_01() {
		int[][] intervals = {{1,4}, {2,5}, {7,9}};
		//Output: [[1,5], [7,9]]
		int[][] result = merge(intervals);
		for (int[] interval : result)
			System.out.print("[" + interval[0] + "," + interval[1] + "] ");
		System.out.println();
	}
	
	@Test
	public void test_02() {
		int[][] intervals = {{6,7}, {2,4}, {5,9}};
		//Output: [[2,4], [5,9]]
		int[][] result = merge(intervals);
		for (int[] interval : result)
			System.out.print("[" + interval[0] + "," + interval[1] + "] ");
		System.out.println();
	}

}
