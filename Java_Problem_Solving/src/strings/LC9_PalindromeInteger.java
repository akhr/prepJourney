package strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class LC9_PalindromeInteger {
	
	public boolean isPalindrome(int x) {
		if (x <= 0 || (x%10 == 0)){
			return false;
		}
		int reversed = 0;
		while(x > reversed) {
			reversed = (reversed * 10) + x%10;
			x = x/10;
		}
		return (x == reversed) || (reversed/10 == x);
	}
	
    public boolean isPalindrome_UsingString(int x) {
        String s = String.valueOf(x);
        char[] sArr = s.toCharArray();
        int l = 0, r = s.length()-1;
        while(l < r){
        	if (sArr[l] != sArr[r]) {
        		return false;
        	}
        	l++; 
        	r--;
        }
        return true;
    }
    
    @Test
    public void Test_1() {
    	int i = 121;
    	assertTrue(isPalindrome(i));
    }
    
    @Test
    public void Test_2() {
    	int i = -121;
    	assertFalse(isPalindrome(i));
    }
    
}