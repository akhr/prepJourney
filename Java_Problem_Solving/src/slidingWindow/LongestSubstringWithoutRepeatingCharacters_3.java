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
			if (charIndxMap.containsKey(c)) {
				int lastIndexOfThisChar = charIndxMap.get(c);
				left = Math.max(left, lastIndexOfThisChar + 1);
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
