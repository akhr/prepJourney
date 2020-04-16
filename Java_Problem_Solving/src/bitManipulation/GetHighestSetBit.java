package bitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetHighestSetBit {
	
	private int getHighestBit(int a) {
		System.out.println("Convert to binary - "+usingConvertToBinary(a));
		System.out.println("Using BitMask - "+usingRightShift(a));
		System.out.println("Using Log - "+usingLog(a));
		
		return usingLog(a);
	}
	
	private int usingLog(int a) {
		if (a == 0) return 0;
		int k = (int)(Math.log(a)/Math.log(2));		
		return 1 << k; //no need of subtracting 1. Its already short by 1
	}
	
	private int usingRightShift(int a) {
		if (a == 0) return 0;
		
		int highBit = 0;
		while(a > 0) {
			a = a >> 1;
			highBit++;
		}
		return 1 << highBit-1;
	}
	
	private int usingConvertToBinary(int a) {
		if (a == 0) return 0;
		
		int highBit = 0;
		while(a > 0) {
			a = a/2;
			highBit++;
		}
		//Minus needed since 1 already has a bit set in 0th position. So left shift only highBit-1 times.
		return 1 << (highBit - 1); 
	}
	
	
	
	@Test
	public void test_01(){
		int num = 11;
		int expected = 8;
		assertEquals(expected, getHighestBit(num));
	}
	
	@Test
	public void test_02(){
		int num = 16;
		int expected = 16;
		assertEquals(expected, getHighestBit(num));
	}

}
