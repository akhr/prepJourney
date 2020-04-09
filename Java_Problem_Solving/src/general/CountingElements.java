/**
 * 
 */
package general;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class CountingElements {

	public int countElements(int[] arr) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int a : arr) { //T(N) = O(N)
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		for(int a : arr) { //T(N) = O(N)
			if (map.containsKey(a+1)) { //T(N) = O(1)
				res++;
				map.put(a+1, map.get(a+1)-1); //T(N) = O(1) + O(1)
			}
		}
		return res;
	}
	
	@Test
	public void Test_01() {
		int[] arr = {1,2,3};
		int expected = 2;
		assertEquals(expected, countElements(arr));
	}
	
	@Test
	public void Test_02() {
		int[] arr = {1,1,3,3,5,5,7,7};
		int expected = 0;
		assertEquals(expected, countElements(arr));
	}

	@Test
	public void Test_03() {
		int[] arr = {1,3,2,3,5,0};
		int expected = 3;
		assertEquals(expected, countElements(arr));
	}
	
	@Test
	public void Test_04() {
		int[] arr = {1,1,2};
		int expected = 2;
		assertEquals(expected, countElements(arr));
	}
}
