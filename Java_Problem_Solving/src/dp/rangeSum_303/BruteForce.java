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
class BruteForce {

	int[] data;
	public BruteForce(int[] nums) {
		this.data = nums;
	}

	public int sumRange(int i, int j) {
		int sum = 0;
		for(int s=i; s<=j; s++) {
			sum += data[s];
		}
		return sum;
	}
}
