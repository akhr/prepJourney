/**
 * 
 */
package backtracking.stringPermutation;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class UsingSwap {
	
	public static void permute(String str) {
		permute(str.toCharArray(), 0, str.length());
	}
	
	private static void permute(char[] chars, int index, int size) {
		if (index == size) {
			System.out.println(new String(chars));
			return;
		}
		
		for(int i=index; i<size; i++) {
			swap(chars, index, i);
			permute(chars, index+1, size);
			swap(chars, index, i);
		}
	}
	
	private static void swap(char[] chars, int a, int b) {
		char t = chars[a];
		chars[a] = chars[b];
		chars[b] = t;
	}
	
	@Test
	public void Test_01() {
		String in = "abc";
		permute(in);
	}
}
