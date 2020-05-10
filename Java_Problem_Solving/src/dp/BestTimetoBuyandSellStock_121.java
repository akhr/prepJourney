/**
 * @authour Akhash Ramamurthy
 */
package dp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class BestTimetoBuyandSellStock_121 {

	public int maxProfit_Greedy(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int currPrice : prices) {
			minPrice = Math.min(minPrice, currPrice);
			int currLocalProfit = currPrice - minPrice;
			maxProfit = Math.max(maxProfit, currLocalProfit);
		}
		return maxProfit;
	}
	
	public int maxProfit_DP_Kadane(int[] prices) {
		if(prices.length < 2) return 0;
		
		int maxProfitEndingHere = 0;
		int maxProfitSoFar = 0;
		for(int i=1; i<prices.length; i++) {
			int priceDiff = prices[i] - prices[i-1];
			
			//DP - making a choice.
			// If currPriceDiff(prices[i] - prices[i-1]) > maxProfitEndingHere
			// If yes, then currPriceDiff better than previously accumulated profit. Then buyDay = i-1 and sellDay = i
			// If not, add currPriceDiff to coming in maxProfitEndingHere and continue
			maxProfitEndingHere = Math.max(priceDiff, maxProfitEndingHere + priceDiff); 
			maxProfitSoFar = Math.max(maxProfitSoFar, maxProfitEndingHere);
		}
		return maxProfitSoFar;
	}
	
	@Test
	public void test_01() {
		int[] prices = new int[]{7,1,5,3,6,4};
		int expected = 5;
		assertEquals(expected, maxProfit_Greedy(prices));
		assertEquals(expected, maxProfit_DP_Kadane(prices));
	}
	
	@Test
	public void test_02() {
		int[] prices = new int[]{7,6,4,3,1};
		int expected = 0;
		assertEquals(expected, maxProfit_Greedy(prices));
		assertEquals(expected, maxProfit_DP_Kadane(prices));
	}
}
