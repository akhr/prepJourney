/**
 * @authour Akhash Ramamurthy
 */
package dp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Akhash Ramamurthy
 *
 */
public class BestTimetoBuyandSellStock_121 {

	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int currPrice : prices) {
			minPrice = Math.min(minPrice, currPrice);
			maxProfit = Math.max(maxProfit, currPrice - minPrice);
		}
		return maxProfit;
	}
	
	@Test
	public void test_01() {
		int[] prices = new int[]{7,1,5,3,6,4};
		int expected = 5;
		assertEquals(expected, maxProfit(prices));
	}
	
	@Test
	public void test_02() {
		int[] prices = new int[]{7,6,4,3,1};
		int expected = 0;
		assertEquals(expected, maxProfit(prices));
	}

}
