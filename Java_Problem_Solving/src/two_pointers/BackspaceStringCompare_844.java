package two_pointers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BackspaceStringCompare_844 {
	
	public boolean backspaceCompare_two_pointer(String S, String T) {
		
	}

	public boolean backspaceCompare_recursive(String S, String T) {
		String a = enforceBackspace(S);
		String b = enforceBackspace(T);
		return a.equalsIgnoreCase(b);
	}

	private String enforceBackspace(String s) {
		if (s.length() == 0 || !s.contains("#")) {
			return s;
		}

		int bsIndx = s.indexOf('#');
		if (bsIndx == 0) {
			s = s.substring(bsIndx+1, s.length());
		}else {
			s = s.substring(0, bsIndx-1) + s.substring(bsIndx+1, s.length());
		}
		return enforceBackspace(s);
	}
	
	@Test
	public void Test_01() {
		String S = "ab#c";
		String T = "ad#c";
		assertTrue(backspaceCompare(S, T));
	}
	
	@Test
	public void Test_02() {
		String S = "ab##";
		String T = "c#d#";
		assertTrue(backspaceCompare(S, T));
	}
	
	@Test
	public void Test_03() {
		String S = "a##c";
		String T = "#a#c";
		assertTrue(backspaceCompare(S, T));
	}
	
	@Test
	public void Test_04() {
		String S = "a##c";
		String T = "#a#d";
		assertFalse(backspaceCompare(S, T));
	}

}
