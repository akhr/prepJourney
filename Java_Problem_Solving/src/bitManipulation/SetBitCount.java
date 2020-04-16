package bitManipulation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SetBitCount {
	
	//Return the count of bits that are set in an integer
	public int countBits(int a) {
		System.out.println("BrianKernighan - "+countBits_BrianKernighan(a));
		System.out.println("BitMask - "+countBits_ANDWithBitMask(a));
		System.out.println("BinaryFormat - "+countBits_ByConvertingToBinary(a));
		return countBits_BrianKernighan(a);
	}
	
	private int countBits_BrianKernighan(int a) {
		int count = 0;
		while(a > 0) {
			a = a & (a-1);
			count++;
		}
		return count;
	}
	
	
	private int countBits_ANDWithBitMask(int a) {
		int mask = 1;
		int count = 0;
		while(a > 0) {
			count += (a & mask);
			a = a >> 1;
		}
		return count;
	}
	
	private int countBits_ByConvertingToBinary(int a) {
		int count = 0;
		while(a > 0) {
			if (a % 2 == 1) count++;
			a = a/2;
		}
		return count;
	}
	
	@Test
	public void test_01() {
		assertEquals(2, countBits(5));
		assertEquals(5, countBits(124));
		assertEquals(6, countBits(867));
	}

}
