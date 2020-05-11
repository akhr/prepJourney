/**
 * @authour Akhash Ramamurthy
 */
package dp.rangeSum_303;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Akhash Ramamurthy
 *
 */

public class Tester {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Tester.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
	
	@Test
	public void test_01() {
		System.out.println("test_01");
		int[] nums = {-2, 0, 3, -5, 2, -1};
		int i=0,j=2;
		int expected = 1;
		BruteForce myClass = new BruteForce(nums);
		assertEquals(expected, myClass.sumRange(i, j));
	}
	
	@Test
	public void test_02() {
		System.out.println("test_02");
		int[] nums = {-2, 0, 3, -5, 2, -1};
		int i=0,j=2;
		int expected = 1;
		DP_Bottom_Up myClass = new DP_Bottom_Up(nums);
		assertEquals(expected, myClass.sumRange(i, j));
	}
}
