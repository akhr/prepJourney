/**
 * 
 */
package heap;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class SortCharactersByFrequency_451 {
	public String frequencySort(String s) {
		if (s == null || s.isBlank())
			return s;
		
		Map<Character, Integer> freqMap = new HashMap<>();
		for(char c : s.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}
		
		Queue<Character> q = new PriorityQueue<>(s.length(), new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				return freqMap.get(c2) - freqMap.get(c1);
			}
		});
		
		for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			q.add(entry.getKey());
		}
		
		StringBuilder sB = new StringBuilder(s.length());
		while(!q.isEmpty()) {
			char c = q.poll();
			for(int i=0; i<freqMap.get(c); i++) {
				sB.append(c);
			}
		}
		return sB.toString();
	}	
	
	@Test
	public void test_01() {
		String s = "tree";
		String expected = "eert";
		assertEquals(expected, frequencySort(s));
	}
	
	@Test
	public void test_02() {
		String s = "cccaaa";
		String expected = "aaaccc";
		assertEquals(expected, frequencySort(s));
	}
	
	@Test
	public void test_03() {
		String s = "Aabb";
		String expected = "bbAa";
		assertEquals(expected, frequencySort(s));
	}
}
