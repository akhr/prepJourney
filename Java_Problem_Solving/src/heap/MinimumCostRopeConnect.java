package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Input: [1, 3, 11, 5]
 * Output: 33
 * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
 * 
 * Input: [1, 3, 11, 5, 2]
 * Output: 42
 * Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)
 */

public class MinimumCostRopeConnect {
	public static int minimumCostToConnectRopes(int[] ropeLengths) {
		Queue<Integer> q = new PriorityQueue<>();
		for(int l : ropeLengths){
			q.offer(l);
		}
		int cost = 0;
		while(q.size() > 1){
			int a = q.poll();
			int b = q.poll();
			cost += a+b;
			q.offer(a+b);
		}
		return cost;
	}

	public static void main(String[] args) {
		int result = minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
		System.out.println("Minimum cost to connect ropes: " + result);
	}
}
