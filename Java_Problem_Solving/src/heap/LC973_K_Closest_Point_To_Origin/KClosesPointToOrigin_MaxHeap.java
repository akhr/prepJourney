package heap.LC973_K_Closest_Point_To_Origin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class KClosesPointToOrigin_MaxHeap {
	
	private static class Point {
		int x, y, d;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			this.d = x*x + y*y;
		}
	}

	public int[][] kClosest(int[][] points, int k){
		int[][] res = new int[k][];	
		
		//max-heap
		Queue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				return b.d - a.d;
			}
		});
		
		for(int i=0; i<points.length; i++) {
			//add k items
			if(q.size() < k) {
				q.add(new Point(points[i][0], points[i][1]));
				continue;
			}
			//after k items add only points which closer to the origin. If longer than q.peek() then ignore the point.
			Point newPoint = new Point(points[i][0], points[i][1]);
			if(newPoint.d < q.peek().d) {
				q.poll();
				q.add(newPoint);
			}
		}
		
		//Copy results from q to int[][]
		for(int i=0; !q.isEmpty(); i++) {
			Point p = q.poll();
			res[i] = new int[] {p.x, p.y};
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
		int[][] res = kClosest(points, 2);
		System.out.println(Arrays.deepToString(res));
	}
}
