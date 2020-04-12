package slidingWindow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumAverageSubarray_I_643 {

	public double findMaxAverage_slidingWindow(int[] nums, int k) {
		if (nums.length == 0) {
            return 0.0;
        }
		if (nums.length == 1) {
            return nums[0];
        }
		
		double maxSum = -Double.MAX_VALUE;
		double sum = 0.0;
		int left, right;
		left = right = 0;
		
		while(right < nums.length) {
			//expand window
			while(right - left < k) {
				sum += nums[right++];
			}
			maxSum = Math.max(maxSum, sum);
			//slide the window
			sum -= nums[left++];
		}
		
		double res = maxSum/(double)k;
		return Math.floor(res * 100000) / 100000;
	} 

	public static double findMaxAverages_bruteforce(int K, int[] arr) {
		int N = arr.length;
		if (N == 0) {
            return 0.0;
        }
		if (N == 1) {
            return arr[0];
        }
		double maxAvg = Double.MIN_VALUE;
		for (int i = 0; i <= N - K; i++) {
			double sum = 0.0;
			for (int j = i ; j < i+K; j++) {
				sum += arr[j];
			}
			maxAvg = Math.max(maxAvg, sum/K);
		}
		return maxAvg;
	}

	@Test
	public void Test_1() {
		int[] a = {1,12,-5,-6,50,3};
		int K = 4 ;
		Double expected = 12.75;
		assertEquals(expected, (Double)findMaxAverage_slidingWindow(a, K));
	}
	
	@Test
	public void Test_2() {
		int[] a = {-1};
		int K = 1 ;
		Double expected = -1.00;
		assertEquals(expected, (Double)findMaxAverage_slidingWindow(a, K));	
	}
	
	@Test
	public void Test_3() {
		int[] a = {8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
		int K = 93 ;
		Double expected = -594.58065;
		Double actual = findMaxAverage_slidingWindow(a, K);
		assertEquals(expected, actual);	
	}


}
