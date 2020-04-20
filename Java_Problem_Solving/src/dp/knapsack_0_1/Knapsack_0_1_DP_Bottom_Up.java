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
public class Knapsack_0_1_DP_Bottom_Up {
	/*Bottom up 
	 * - NO RECURSION
	 * - Hardcode answers for base cases
	 * - Use a FOR loop - Move from LEAF to ROOT
	*/
	
	/**
	 * Items A, B, C, D
	 * int[] profits = {1, 6, 10, 16};
	 * int[] weights = {1, 2, 3, 5};
	 * Capacity = 7kgs
	 */
	
	/**
	 * Complete DP Cache - Each cell is the PROFIT
	 * 						C=0	C=1	C=2	C=3	C=4	C=5	C=6	C=7			
	 * 	(w 1, p 1)	Item1	0	1	1	1	1	1	1	1
	 * 	(w 2, p 6)	Item2	0	1	6	7	7	7	7	7	
	 * 	(w 3, p 10)	Item3  	0	1	6	10	11	16	17	17
	 * 	(w 5, p 16)	Item4  	0	1	6	10	11	16	17	22		
	 */

	public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		int n = weights.length;
		Integer[][] dp = new Integer[n][capacity+1];
		
		/** 
		 *  Base case only DP Cache
		 * 			C=0	C=1	C=2	C=3	C=4	C=5	C=6	C=7			
		 * 	Item 1	0	1	1	1	1	1	1	1
		 * 	Item 2	0	
		 * 	Item 3  0	
		 * 	Item 4  0			
		 */
		
		// populate the capacity=0 columns, with '0' capacity we have '0' profit
		for (int item=0; item<n; item++ ) {
			dp[item][0] = 0;
		}

		// if we have only one weight, we will take it if it is not more than the capacity  
		for (int c=0; c<=capacity; c++) {
			if(weights[0] <= c) {
				dp[0][c] = profits[0];
			}
		}
		
		for (int item=1; item<n; item++) {
			for(int cap=1; cap<=capacity; cap++) {
				
				int profit1 = 0;
				// include the item, if it is not more than the capacity
				if(weights[item] <= cap) {
					int newCapacity = cap - weights[item];
					profit1 = profits[item] + dp[item-1][newCapacity];
				}
				// exclude the item
				int profit2 = dp[item-1][cap];
				// take maximum
				dp[item][cap] = Math.max(profit1, profit2);;
			}
		}
		
		printSelectedElements(dp, weights, profits, capacity);
		return dp[n-1][capacity];
	}
	
	/**
	 * Complete DP Cache - Each cell is the PROFIT
	 * 						C=0	C=1	C=2	C=3	C=4	C=5	C=6	C=7			
	 * 	(w 1, p 1)	Item1	0	1	1	1	1	1	1	1
	 * 	(w 2, p 6)	Item2	0	1	6	7	7	7	7	7	
	 * 	(w 3, p 10)	Item3  	0	1	6	10	11	16	17	17
	 * 	(w 5, p 16)	Item4  	0	1	6	10	11	16	17	22		
	 */
	private static void printSelectedElements(Integer[][] dp, int[] weights, int[] profits, int capacity) {
		int n = weights.length;
		int totalProfit = dp[n-1][capacity];
		
		for(int item=n-1; item>0; item--) {
			if(dp[item-1][capacity] != totalProfit) {
				//then this item is included.
				System.out.println("Included Item - "+weights[item]);
				capacity -= weights[item];
				totalProfit -= profits[item];
			}
		}
		
		if(totalProfit != 0)
			System.out.println("Included Item - "+weights[0]);
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
