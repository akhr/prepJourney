package heap.LC973_K_Closest_Point_To_Origin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class KClosestPointToOrigin_MinHeap {

	private static class Point {
		int x, y;
		int d;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			this.d = calcDistFromOrigin();
		}
		
		private int calcDistFromOrigin() {
            return this.x * this.x + this.y * this.y;
		}
	}
	
	private Comparator<Point> comp = new Comparator<Point>() {
		@Override
		public int compare(Point p1, Point p2) {
			if (p1.d < p2.d) return -1;
			if (p1.d > p2.d) return 1;
			return 0;
		}
	};
	
	public int[][] kClosest(int[][] points, int K) {
		int[][] res = new int[K][2];
		Queue<Point> heap = new PriorityQueue<Point>(comp);
		
		for(int[] point : points) {
			Point p = new Point(point[0], point[1]);
			heap.offer(p);
		}
		
		System.out.println("Heap :: "+Arrays.deepToString(heap.toArray()));
		
		for(int i = 0; i < K; i++) {
			Point p = heap.poll();
			res[i] = new int[]{p.x, p.y};
		}
		
		return res;
	}
	
	@Test
	public void Test_1() {
		int[][] points = {{1,3},{-2,2}};
		int[][] res = kClosest(points, 1);
		System.out.println(Arrays.deepToString(res));
	}
	
	@Test
	public void Test_2() {
		int[][] points = {{3,3},{5,-1},{-2,4}};
//		int[][] expected = {{3,3}, {-2,4}};
		int[][] res = kClosest(points, 2);
		System.out.println(Arrays.deepToString(res));
	}

}
