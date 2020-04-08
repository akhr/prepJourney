package backtracking_print_all.stringPermutation;

import org.junit.Test;

public class UsingSubstring {

	public static void permute(String str) {
		permute("", str);
	}
	
	private static void permute(String prefix, String str) {
		if (str.isEmpty()) {
			System.out.println(prefix);
		}
		
		for (int i=0; i<str.length(); i++) {
			String newPrefix = prefix + str.charAt(i);
			String newStr = str.substring(0, i) + str.substring(i+1, str.length());
			permute(newPrefix, newStr);
		}
	}
	
	@Test
	public void Test_01() {
		String in = "abc";
		permute(in);
	}
}
