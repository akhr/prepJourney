/**
 * 
 */
package bitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class ReverseBits_190 {

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int res = 0;
		for (int i=0; i<32; i++) {
			int rightmostBit = n & 1;
			n = n >> 1;
			res = res << 1;
			res = res | rightmostBit;
		}
		return res;
	}
	
	public int reverseBits_2(int n) {
        int result = 0;
        for (int i = 0;i<32;i++){
            int end = n & 1;
            n >>= 1;
            result <<=1;
            result |= end;
        }
        return result;
    }
}
