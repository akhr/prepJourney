/**
 * 
 */
package slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class FB_LongestSubstrWithAtMostKDistinctChars_340 {

	public int lengthOfLongestSubstringKDistinct_charIndexMap(String s, int k) {
		int n = s.length();
		if (n*k == 0) return 0;

		// sliding window left and right pointers
		int left = 0;
		int right = 0;
		// hashmap character -> its rightmost position 
		// in the sliding window
		LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

		int max_len = 1;

		while (right < n) {
			Character character = s.charAt(right);
			// if character is already in the hashmap -
			// delete it, so that after insert it becomes
			// the rightmost element in the hashmap
			if (hashmap.containsKey(character))
				hashmap.remove(character);
			hashmap.put(character, right++);

			// slidewindow contains k + 1 characters
			if (hashmap.size() == k + 1) {
				// delete the leftmost character
				Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
				hashmap.remove(leftmost.getKey());
				// move left pointer of the slidewindow
				left = leftmost.getValue() + 1;
			}

			max_len = Math.max(max_len, right - left);
		}
		return max_len;
	}

	public int lengthOfLongestSubstringKDistinct_charFreqMap(String s, int k) {
		if (s.isEmpty() || k <= 0) {
			return 0;
		}

		Map<Character, Integer> charFreqMap = new HashMap<>();
		int distinctCharCount = 0;
		int maxLen = Integer.MIN_VALUE;
		int left, right, n;
		left = right = 0;
		n = s.length();

		while (right < n) {
			char c = s.charAt(right);
			if (charFreqMap.containsKey(c) ) {
				charFreqMap.put(c, charFreqMap.get(c) + 1);
				maxLen = Math.max(maxLen, right - left + 1);
			} else {
				if (distinctCharCount < k) {
					charFreqMap.put(c, 1);
					distinctCharCount++;
					maxLen = Math.max(maxLen, right - left + 1);
				} else {
					//shrink window
					while (distinctCharCount == k) {
						char shrinkChar = s.charAt(left);
						charFreqMap.put(shrinkChar, charFreqMap.get(shrinkChar) - 1);
						left++;
						if (charFreqMap.get(shrinkChar) == 0) {
							charFreqMap.remove(shrinkChar);
							distinctCharCount--;
						}
					}
					continue;
				}
			}
			right++;
		}
		return maxLen == Integer.MIN_VALUE ? 0: maxLen;
	}

	@Test
	public void test_01() {
		String s = "araaci";
		int k = 2;
		int expected = 4;
		//		assertEquals(expected, lengthOfLongestSubstringKDistinct_charFreqMap(s, k));
		assertEquals(expected, lengthOfLongestSubstringKDistinct_charIndexMap(s, k));
	}

	@Test
	public void test_02() {
		String s = "araaci";
		int k = 1;
		int expected = 2;
		//		assertEquals(expected, lengthOfLongestSubstringKDistinct_charFreqMap(s, k));
		assertEquals(expected, lengthOfLongestSubstringKDistinct_charIndexMap(s, k));
	}

	@Test
	public void test_03() {
		String s = "";
		int k = 0;
		int expected = 0;
		//		assertEquals(expected, lengthOfLongestSubstringKDistinct_charFreqMap(s, k));
		assertEquals(expected, lengthOfLongestSubstringKDistinct_charIndexMap(s, k));
	}

	@Test
	public void test_04() {
		String s = "a";
		int k = 0;
		int expected = 0;
		//		assertEquals(expected, lengthOfLongestSubstringKDistinct_charFreqMap(s, k));
		assertEquals(expected, lengthOfLongestSubstringKDistinct_charIndexMap(s, k));
	}

	@Test
	public void test_05() {
		String s = "a";
		int k = 1;
		int expected = 1;
		//		assertEquals(expected, lengthOfLongestSubstringKDistinct_charFreqMap(s, k));
		assertEquals(expected, lengthOfLongestSubstringKDistinct_charIndexMap(s, k));
	}
}
