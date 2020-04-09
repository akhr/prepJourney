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
public class Knapsack_0_1_DP_Top_Down {
	/* Top-Down 
	 * - USE RECURSION
	 * - Move from ROOT to LEAF 
	 * - Calculate LEAF result and return to PARENT. 
	 * - Walk BACK to ROOT
	 * - DFS
	*/
	
	/*
	 * T(N) = N * C
	 * S(N) = (N * C) + N = N * C
	 * Since our memoization array dp[profits.length][capacity+1] stores the results for all subproblems, we can conclude that we will not have more than N*C subproblems 
	 * (where ‘N’ is the number of items and ‘C’ is the knapsack capacity). 
	 * This means that our time complexity will be O(N*C).
	 * The above algorithm will use O(N*C) space for the memoization array. 
	 * Other than that we will use O(N) space for the recursion call-stack. So the total space complexity will be O(N*C + N), which is asymptotically equivalent to O(N*C).
	 */
	
	/*
		 Items A, B, C, D
		 int[] profits = {1, 6, 10, 16};
		 int[] weights = {1, 2, 3, 5};
		 Capacity = 7kgs
	 */

	public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		Integer[][] dp = new Integer[weights.length][capacity+1];
		return recurse(profits, weights, capacity, 0, dp);
	}

	private static int recurse(int[] profits, int[] weights, int capacity, int currIndex, Integer[][] dp) {
		if (currIndex >= weights.length || capacity <= 0) {
			return 0;
		}

		if (dp[currIndex][capacity] != null) {
			return dp[currIndex][capacity];
		}

		int profit1 = 0;
		if (weights[currIndex] <= capacity) {
			int newCapacity = capacity - weights[currIndex];
			profit1 = profits[currIndex] + recurse(profits, weights, newCapacity, currIndex+1, dp);
		}
		int profit2 = recurse(profits, weights, capacity, currIndex+1, dp);

		int profitForThisItemAndCapacity = Math.max(profit1, profit2);
		dp[currIndex][capacity] = profitForThisItemAndCapacity;

		return profitForThisItemAndCapacity;
	}

	@Test
	public void Test_01() {
		int[] profits = {1, 6, 10, 16};
		int[] weights = {1, 2, 3, 5};
		int capacity= 7;
		int expected = 22;
		assertEquals(expected, solveKnapsack(profits, weights, capacity));
	}
	
	@Test
	public void Test_02() {
		int[] profits = {1, 6, 10, 16};
		int[] weights = {1, 2, 3, 5};
		int capacity= 6;
		int expected = 17;
		assertEquals(expected, solveKnapsack(profits, weights, capacity));
	}
}
