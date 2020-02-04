package heap.LC1046_LastStoneWeight;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
		int n = stones.length;
        if (n == 0) return 0;
        if (n == 1) return stones[0];
        if (n == 2) return Math.abs(stones[0] - stones[1]);
        
		Queue<Integer> heap = new PriorityQueue<>(n, comp);
		for (int stone : stones) {
			heap.offer(stone);
		}

		while(!heap.isEmpty() && heap.size() > 1) {
			int y = heap.poll();
			int x = heap.poll();
			if (y == x) continue;
			else {
				heap.offer(y-x);
			}
		}
		if (heap.isEmpty()) return 0;
		return heap.poll();
	}

	Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer x, Integer y) {
			return y - x;
		}
	};
	
	@Test
	public void Test_1() {
		int[] stones = {2,7,4,1,8,1};
		int expected = 1;
		System.out.println("last stone :: " + lastStoneWeight(stones));
		assertEquals(expected, lastStoneWeight(stones));
	}
	
	@Test
	public void Test_2() {
		int[] stones = {7, 8};
		int expected = 1;
		System.out.println("last stone :: " + lastStoneWeight(stones));
		assertEquals(expected, lastStoneWeight(stones));
	}
	
	@Test
	public void Test_3() {
		int[] stones = {8,8};
		int expected = 0;
		System.out.println("last stone :: " + lastStoneWeight(stones));
		assertEquals(expected, lastStoneWeight(stones));
	}
	
	@Test
	public void Test_4() {
		int[] stones = {8};
		int expected = 8;
		System.out.println("last stone :: " + lastStoneWeight(stones));
		assertEquals(expected, lastStoneWeight(stones));
	}

}
