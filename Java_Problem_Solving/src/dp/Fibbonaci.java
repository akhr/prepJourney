/**
 * @fileName: Fibbonaci.java
 * @author: ramamurthy
 * @CreatedOn: Jan 26, 2020
 * 
 */
package dp;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * @fileName: Fibbonaci.java
 * @author: ramamurthy
 * @Created on: Jan 26, 2020
 * 
 */
public class Fibbonaci {
	
	public int fib(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, 0);
		cache.put(1, 1);
		return fibHelper(n, cache);
	}
	
	
	// Template for DP Top-Down function
	private int fibHelper(int n, Map<Integer, Integer> cache) {
		//Check Cache
		if (cache.containsKey(n)) 
			return cache.get(n);
		// If not in cache do the computation step
		int ret1 = fibHelper(n-1, cache);
		int ret2 = fibHelper(n-2, cache);
		// Store result in cache
		cache.put(n, ret1 + ret2);
		// Return val
		return ret1 + ret2;
	}
	
	// Template for DP Bottom-Up function
	private int fib_DP_2(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, 0);
		cache.put(1, 1);
		for (int i=2; i<=n; i++) {
			int c = cache.get(i-1) + cache.get(i-2);
			cache.put(i, c);
		}
		return cache.get(n);
	}
	
	@Test
	public void Test_1() {
		assertEquals(0, fib(0));
		assertEquals(1, fib(1));
		assertEquals(1, fib(2));
		assertEquals(2, fib(3));
		assertEquals(3, fib(4));
		assertEquals(701408733, fib(44));
	}
	
	@Test
	public void Test_2() {
		assertEquals(0, fib_DP_2(0));
		assertEquals(1, fib_DP_2(1));
		assertEquals(1, fib_DP_2(2));
		assertEquals(2, fib_DP_2(3));
		assertEquals(3, fib_DP_2(4));
		assertEquals(701408733, fib_DP_2(44));
	}

}
