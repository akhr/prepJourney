/**
 * 
 */
package slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.isEmpty()) {
			return 0;
		}
		
		Map<Character, Integer> charIndxMap = new HashMap<>();
		int left, right, maxLen;
		left = right = 0;
		maxLen = 1;
		
		while(right < s.length()) {
			char c = s.charAt(right);
			
			//If contains then we need to exclude the char from current window
			if (charIndxMap.containsKey(c)) {
				// Get lastIndex where this char was seen.
				// Eg a b b a
				//    0 1 2 3
				// When 2nd time we see 'a' @ index 3 Map = {{a,0}, {b,2}}, left = 2 and right = 3
				// since left is at 2 we already excluded from the window. But how will we know?
				int lastIndexOfThisChar = charIndxMap.get(c);
				// Either I can check 
				//  - if window already excluded 'a' by checking lastIndex(a) < left
				//      - if yes, we moved past 'a'. No action needed.
				//      - if no, new left = lastIndex(a) + 1
				if (lastIndexOfThisChar >= left) {
					left = lastIndexOfThisChar + 1;
				}
				
				// OR
				
				//  - Simply Math.max(left, lastIndex(a)+1) 
				// left = Math.max(left, lastIndexOfThisChar + 1);
			}
			charIndxMap.put(c, right);
			maxLen = Math.max(maxLen, right - left + 1);
			right++;
		}
		return maxLen;
	}
	
	@Test
	public void test_01() {
		String s = "aabccbb";
		int expected = 3;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_02() {
		String s = "abbbb";
		int expected = 2;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_03() {
		String s = "abccde";
		int expected = 3;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_04() {
		String s = "";
		int expected = 0;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_05() {
		String s = null;
		int expected = 0;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_06() {
		String s = "abcabcbb";
		int expected = 3;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_07() {
		String s = "bbbbb";
		int expected = 1;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_08() {
		String s = "pwwkew";
		int expected = 3;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_09() {
		String s = "abba";
		int expected = 2;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}


}
