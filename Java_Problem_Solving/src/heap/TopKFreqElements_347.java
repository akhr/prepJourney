/**
 * 
 */
package heap;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class TopKFreqElements_347 {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>(k);
		Map<Integer, Integer> freqMap = new HashMap<>();

		//load freqMap
		for(int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		Queue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return freqMap.get(o1) - freqMap.get(o2);
			}
		});
		Iterator<Map.Entry<Integer, Integer>> iterator = freqMap.entrySet().iterator();

		while(iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
			if(q.size() < k) {
				q.add(entry.getKey());
				continue;
			}
			if(entry.getValue() > freqMap.get(q.peek())) {
				q.poll();
				q.add(entry.getKey());
			}
		}

		while(!q.isEmpty()) {
			res.add(q.poll());
		}
		return res;
	}

	@Test
	public void test_01() {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		List<Integer> expecteds = new ArrayList<>();
		expecteds.add(2);
		expecteds.add(1);
		assertArrayEquals(expecteds.toArray(), topKFrequent(nums, k).toArray());
	}

	@Test
	public void test_02() {
		int[] nums = {1};
		int k = 1;
		List<Integer> expecteds = new ArrayList<>();
		expecteds.add(1);
		assertArrayEquals(expecteds.toArray(), topKFrequent(nums, k).toArray());
	}


	@Test
	public void test_03() {
		int[] nums = {4,1,-1,2,-1,2,3};
		int k = 2;
		List<Integer> expecteds = new ArrayList<>();
		expecteds.add(-1);
		expecteds.add(2);
		assertArrayEquals(expecteds.toArray(), topKFrequent(nums, k).toArray());
	}
	
	@Test
	public void test_04() {
		int[] nums = {1, 3, 5, 12, 11, 12, 11};
		int k = 2;
		List<Integer> expecteds = new ArrayList<>();
		expecteds.add(11);
		expecteds.add(12);
		assertArrayEquals(expecteds.toArray(), topKFrequent(nums, k).toArray());
	}
}
