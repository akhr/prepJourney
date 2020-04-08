/**
 * 
 */
package dp.knapsack_0_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class Knapsack_0_1_BruteForce {

	/*
		 Items A, B, C, D
		 int[] profits = {1, 6, 10, 16};
    	 int[] weights = {1, 2, 3, 5};
    	 Capacity = 7kgs
	 */
	
	/*
	 Brute force -> T(N) = 2^N, S(N) = 2^N
	 
	 */

	public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		return recursive(profits, weights, capacity, 0);
	}

	private static int recursive(int[] profits, int[] weights, int capacity, int currIndex) {
		if (capacity <= 0 || currIndex == profits.length) {
			return 0;
		}

		int profit1 = 0;
		if (weights[currIndex] <= capacity) {
			int newCapacity = capacity - weights[currIndex];
			profit1 = profits[currIndex] + recursive(profits, weights, newCapacity, currIndex+1);
		} 
		int profit2 = recursive(profits, weights, capacity, currIndex+1);
		return Math.max(profit1, profit2);
	}

	@Test
	public void Test_01() {
		int[] weights = { 2, 3, 1, 4 };
		int[] profits = { 4, 5, 3, 7 };
		int capacity= 5;
		int expected = 10;
		assertEquals(expected, solveKnapsack(profits, weights, capacity));
	}

}
