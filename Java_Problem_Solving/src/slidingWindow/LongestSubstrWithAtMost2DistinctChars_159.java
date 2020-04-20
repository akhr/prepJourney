package slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class LongestSubstrWithAtMost2DistinctChars_159 {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> charIndexMap = new LinkedHashMap<>();
		int left = 0, right = 0, maxLen = Integer.MIN_VALUE;

		while(right < s.length()) {
			char c = s.charAt(right);
			//expand window
			if (charIndexMap.containsKey(c)) {
				charIndexMap.remove(c);
			}
			charIndexMap.put(c, right);

			if(charIndexMap.size() > 2) {
				//shrink window
				Map.Entry<Character, Integer> leftmost = charIndexMap.entrySet().iterator().next();
				left = leftmost.getValue() + 1;
				charIndexMap.remove(leftmost.getKey());
			}
			maxLen = Math.max(maxLen, right-left+1);
			right++;
		}
		return maxLen == Integer.MIN_VALUE ? 0:maxLen;
	}
	
	@Test
	public void test_01() {
		String s = "eceba";
		int expected = 3;
		assertEquals(expected, lengthOfLongestSubstringTwoDistinct(s));
	}
	
	@Test
	public void test_02() {
		String s = "ccaabbb";
		int expected = 5;
		assertEquals(expected, lengthOfLongestSubstringTwoDistinct(s));
	}

}
