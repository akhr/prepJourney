/**
 * 
 */
package general;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class HappyNumber {

	public boolean isHappy(int n) {
		int slowPointer = n;
		int fastPointer = getNext(n);

		while(fastPointer != 1 && fastPointer != slowPointer) {
			slowPointer = getNext(slowPointer);
			fastPointer = getNext(getNext(fastPointer));
		}
		return fastPointer == 1;
	}

	private int getNext(int n) {
		int sum = 0;
		while(n > 0) {
			int d = n%10;
			sum += d * d;
			n = n/10;
		}
		return sum;
	}
	
	/*public boolean isHappy(int n) {
			if (n <= 0) {
				return false;
			}

			int maxIteration = 25;
			int currIteration = 0;
			while(n != 1) {
				if(currIteration == maxIteration) {
					System.out.println("Not a Happy Number :-(");
					return false;
				}
				n = squaring(n);
				System.out.println("New n = " + n);
				currIteration++;
			}
			System.out.println("Is Happy Number :-)");
			return true;
		}*/

	/*private int squaring(int x) {
			int res = 0;
			int digit = 0;
			while(x > 0) {
				digit = x%10;
				res += Math.pow(digit, 2);
				x = x/10;
			}
			return res;
		}*/

	@Test
	public void Test_01() {
		int in = 19;
		assertTrue(isHappy(in));
	}

	@Test
	public void Test_02() {
		int in = 7;
		assertTrue(isHappy(in));
	}

	@Test
	public void Test_03() {
		int in = 116;
		assertFalse(isHappy(in));
	}
}
