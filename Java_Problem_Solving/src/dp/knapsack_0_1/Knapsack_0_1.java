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
public class Knapsack_0_1 {

	/*
		Items: { Apple, Orange, Banana, Melon }
		Weights: { 2, 3, 1, 4 }
		Profits: { 4, 5, 3, 7 }
		Knapsack capacity: 5
	 */

	public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		return recursive(profits, weights, capacity, 0);
	}

	private static int recursive(int[] profits, int[] weights, int capacity, int currIndex) {
		System.out.printf("Enter recursive capacity-%d, currIndex-%d\n", capacity, currIndex);
		System.out.printf("-------------------------------------------\n");
		if (capacity <= 0) {
			System.out.println("Reached max capacity return 0");
			return 0;
		}
		if (currIndex == profits.length) {
			System.out.println("Reached end of array");
			return 0;
		}

		int profit1 = 0;
		if (weights[currIndex] <= capacity) {
			System.out.printf("Include currIndex-%d, weight-%d\n", currIndex, weights[currIndex]);
			int newCapacity = capacity - weights[currIndex];
			profit1 = profits[currIndex] + recursive(profits, weights, newCapacity, currIndex+1);
			System.out.printf("\tprofit1-%d, currIndex-%d, weight-%d\n", profit1, currIndex, weights[currIndex]);
		} else {
			System.out.printf("SKIPPED currIndex-%d, weight-%d\n", currIndex, weights[currIndex]);
		}
		
		int profit2 = recursive(profits, weights, capacity, currIndex+1);
		System.out.printf("\tprofit2-%d, currIndex-%d, weight-%d\n", profit2, currIndex, weights[currIndex]);
		
		System.out.println("\t\tReturning - "+Math.max(profit1, profit2));

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
