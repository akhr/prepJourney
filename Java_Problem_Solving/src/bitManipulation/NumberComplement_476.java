/**
 * 
 */
package bitManipulation;

import org.junit.Test;
import static org.junit.Assert.assertEquals; 

/**
 * @author ramamurthy
 *
 */
public class NumberComplement_476 {
	
	public int findComplement_BitLenBitMask(int num) {
		if (num <= 1) return num ^ 1;
		
		//Count set bits - Brian-Kernighans
		int k = (int)(Math.log(num) / Math.log(2)) + 1;
		
		//create bitmask
		//for 2 set bits left shift by 3 places and subtract 1. Plus 1 needed so that mask will have all positions of set bit count as 1's.
		//Since left shifting 1 rest all bits are 0's. So we always end up with numbers like 1,2,4,8,16,32,64,128,256 etc...
		// So this_number-1 is always going to contain only 1's. eg 127 0111 1111 
		int bitMask = (1 << k) - 1; 
		
		// x ^ 0 = x
		// x ^ 1 = !x 
		int res = num ^ bitMask;
		return res;
	}
	
	public int findComplement_bitByBit(int num) {
		int todo = num, bit =1;
		while(todo != 0) {
			num = num ^ bit;
			bit = bit << 1;
			todo = todo >> 1;
		}
		return num;
	}
	
	@Test
	public void test_01(){
		int num = 5;
		int expected = 2;
		assertEquals(expected, findComplement_bitByBit(num));
	}
	
	@Test
	public void test_02(){
		int num = 11;
		int expected = 4;
		assertEquals(expected, findComplement_bitByBit(num));
	}
	
	@Test
	public void test_03(){
		int num = 5;
		int expected = 2;
		assertEquals(expected, findComplement_BitLenBitMask(num));
	}
	
	@Test
	public void test_04(){
		int num = 11;
		int expected = 4;
		assertEquals(expected, findComplement_BitLenBitMask(num));
	}
	
	@Test
	public void test_05(){
		int num = 8;
		int expected = 7;
		assertEquals(expected, findComplement_BitLenBitMask(num));
	}
	
	@Test
	public void test_06(){
		int num = 10;
		int expected = 5;
		assertEquals(expected, findComplement_BitLenBitMask(num));
	}
}
