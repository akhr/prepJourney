/**
 * @authour Akhash Ramamurthy
 */
package slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class FB_MinimumWindowSubstring_76 {

	public String minWindow(String s, String t) {
		if (s == null || t ==null || s.length() == 0 || t.length() == 0 || s.length()<t.length())
			return "";

		Map<Character, Integer> charFreqMap = new HashMap<>();
		for(char c : t.toCharArray()) {
			charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0, counter = t.length();
		int minWinSize = Integer.MAX_VALUE, minWinLeft = -1;

		while(right < s.length()) { //expand window - while loop
			char expandChar = s.charAt(right++);
			
			if(charFreqMap.containsKey(expandChar)){
				if (charFreqMap.get(expandChar) > 0) //Decr counter only if c is needed. Dont bother for extra c's.
					counter--; 
				charFreqMap.put(expandChar, charFreqMap.get(expandChar) - 1);
			}

			while(counter == 0) {
				//Record window size
				int windowSize = right-left; // Already right is incremented
				if(windowSize < minWinSize) {
					minWinSize = windowSize;
					minWinLeft = left;
				}

				char shrinkChar = s.charAt(left++);
				if(charFreqMap.containsKey(shrinkChar)){
					if (charFreqMap.get(shrinkChar) >= 0) //Removing extra available c will not affect the counter. If required c Incr counter.
						counter++; 
					charFreqMap.put(shrinkChar, charFreqMap.get(shrinkChar) + 1);
				}
			}
		}
		return minWinSize == Integer.MAX_VALUE ? "" : s.substring(minWinLeft, minWinLeft+minWinSize);
	}

	@Test
	public void test_01() {
		String s = "ADOBECODEBANC", t = "ABC";
		String expected = "BANC";
		assertEquals(expected, minWindow(s, t));
	}

	@Test
	public void test_02() {
		String s = "", t = "ABC";
		String expected = "";
		assertEquals(expected, minWindow(s, t));
	}

	@Test
	public void test_03() {
		String s = "", t = "";
		String expected = "";
		assertEquals(expected, minWindow(s, t));
	}

	@Test
	public void test_04() {
		String s = null, t = "";
		String expected = "";
		assertEquals(expected, minWindow(s, t));
	}

	@Test
	public void test_05() {
		String s = "", t = null;
		String expected = "";
		assertEquals(expected, minWindow(s, t));
	}

	@Test
	public void test_06() {
		String s = "a", t = "aa";
		String expected = "";
		assertEquals(expected, minWindow(s, t));
	}

	@Test
	public void test_07() {
		String s = "a", t = "b";
		String expected = "";
		assertEquals(expected, minWindow(s, t));
	}
}
