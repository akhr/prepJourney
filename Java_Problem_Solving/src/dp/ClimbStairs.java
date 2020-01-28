/**
 * @fileName: ClimbStairs.java
 * @author: ramamurthy
 * @CreatedOn: Jan 27, 2020
 * 
 */
package dp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @fileName: ClimbStairs.java
 * @author: ramamurthy
 * @Created on: Jan 27, 2020
 * 
 */
public class ClimbStairs {
	/*----------  DP Recursive - Top Down ----------------*/
	public int climbStairs(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0,0);
		cache.put(1,1);
		cache.put(2,2);
		return helper(n, cache);
	}
	
	private int helper(int n, Map<Integer, Integer> cache) {
		if (cache.containsKey(n))
			return cache.get(n);
		int ret = helper(n-1, cache) + helper(n-2, cache);
		cache.put(n, ret);
		return ret;
	}
	
	/*----------  DP - Bottom Up ----------------*/
	public int climbStairs_2(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0,0);
		cache.put(1,1);
		cache.put(2,2);
		
		for(int i=3; i<=n; i++) {
			int ret = cache.get(i-1) + cache.get(i-2);
			cache.put(i, ret);
		}
		return cache.get(n);
	}
	
	@Test
	public void Test_1() {
		assertEquals(3, climbStairs(3));
		assertEquals(5, climbStairs(4));
		assertEquals(8, climbStairs(5));
		assertEquals(3, climbStairs_2(3));
		assertEquals(5, climbStairs_2(4));
		assertEquals(8, climbStairs_2(5));
	}
}
