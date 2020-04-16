package bitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegerBinaryConversion {

	public String intToBinary(int a) {
		StringBuilder sB = new StringBuilder();
		while (a >= 1) {
			int bit = a % 2;
			sB.append(bit);
			a /= 2;
		}
		// Reverse required
		return sB.reverse().toString();
	}

	public int binaryToInt(String b) {
		char[] charArr = b.toCharArray();
		int dec = 0;
		for(int i=charArr.length-1, exp=0; i>=0; i--, exp++) {
			int t =  (int)Math.pow(2, exp);
			dec += (charArr[i]-48) * t;
		}
		return dec;
	}

	@Test
	public void test_01() {
		int a = 16;
		String expected = "10000";
		String actual = intToBinary(a);
		assertEquals(expected, actual);
	}

	@Test
	public void test_02() {
		int a = 170;
		String expected = "10101010";
		String actual = intToBinary(a);
		assertEquals(expected, actual);
	}

	@Test
	public void test_03() {
		String b = "10101010";
		int expected = 170;
		int actual = binaryToInt(b);
		assertEquals(expected, actual);
	}

}
