package bitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegerBinaryConversion {

	public String intToBinary(int a) {
		StringBuilder sB = new StringBuilder();
		while (a >= 1) {
			int bit = a % 2;
			sB.append(bit);
			a = a >> 1;
		}
		// Reverse required
		return sB.reverse().toString();
	}
	
	public int binaryToInt(String b) {
		char[] charArr = b.toCharArray();
		int dec = 0;
		for(int i=charArr.length-1, exp=0; i>=0; i--, exp++) {
			dec += (charArr[i]-48) * (1 << exp);
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
	
	@Test
	public void test_04() {
		String b = "10001";
		int expected = 17;
		int actual = binaryToInt(b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_05() {
		String b = "01111110";
		int expected = 126;
		int actual = binaryToInt(b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_06() {
		String b = "0000000110000011";
		int expected = 387;
		int actual = binaryToInt(b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_07() {
		int a = 387;
		String expected = "110000011";
		String actual = intToBinary(a);
		assertEquals(expected, actual);
	}


}
