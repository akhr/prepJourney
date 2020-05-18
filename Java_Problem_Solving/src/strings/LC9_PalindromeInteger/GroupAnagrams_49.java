/**
 * @authour Akhash Ramamurthy
 */
package strings.LC9_PalindromeInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class GroupAnagrams_49 {

	public List<List<String>> groupAnagrams_Sorting(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs.length == 0) return res;
		Map<String, List<String>> map = new HashMap<>();
		
		for(String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String sortedKey = new String(arr);
			if (!map.containsKey(sortedKey)) {
				map.put(sortedKey, new ArrayList<String>());
			}
			map.get(sortedKey).add(str);
		}
		res.addAll(map.values());
		return res;
	}
	
	public List<List<String>> groupAnagrams_Count(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs.length == 0) return res;
		Map<String, List<String>> map = new HashMap<>();
		
		for(String str : strs) {
			int[] countArr = new int[26];
			for(char c : str.toCharArray()) {
				countArr[c - 'a']++;
			}
			String key = Arrays.toString(countArr);
			System.out.println("key : "+key);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		System.out.println("map : "+map);
		res.addAll(map.values());
		return res;
	}
	
	@Test
	public void test01() {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams_Sorting(strs));
	}
	
	@Test
	public void test0() {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams_Count(strs));
	}

}
