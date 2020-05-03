/**
 * @authour Akhash Ramamurthy
 */
package merge_interval;

import java.util.LinkedList;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval_57 {


	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) return new int[][] {newInterval};

		LinkedList<int[]> merged = new LinkedList<>();
		int indx = 0;
		
		//Add add intervals with start <= newInterval.start
		while(indx < intervals.length && intervals[indx][0] <= newInterval[0]) { 
			merged.add(intervals[indx]);
			indx++;
		}
		indx--; // Now going to work on last added interval and newInterval. So lets point indx to last added segment.

		boolean inserted = false; //once newInterval inserted int mergedList stop using newInterval
		
		while(indx < intervals.length) {
			if (merged.isEmpty()) { // So 1st interval is newInterval
				merged.add(newInterval);
				continue;
			}
			int[] a = merged.getLast();
			int[] b = !inserted ? newInterval : intervals[indx];
			if (!inserted) inserted = !inserted; //toggle flag

			if(a[1] >= b[0]) { //overlapping. Merge into one
				a[1] = Math.max(a[1], b[1]);
			}else { //non overlapping
				merged.add(b);
			}
			indx++;
		}
		return merged.toArray(new int[merged.size()][2]);
	}

	@Test
	public void test_01() {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4,8};
		//Output: [[1,2],[3,10],[12,16]]

		int[][] result = insert(intervals, newInterval);
		for (int[] interval : result)
			System.out.print("[" + interval[0] + "," + interval[1] + "] ");
		System.out.println();
	}

	@Test
	public void test_02() {
		int[][] intervals = {{1,5}};
		int[] newInterval = {0,3};
		//Output: [[0,5]]

		int[][] result = insert(intervals, newInterval);
		for (int[] interval : result)
			System.out.print("[" + interval[0] + "," + interval[1] + "] ");
		System.out.println();
	}
}
