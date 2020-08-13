/**
 * @authour Akhash Ramamurthy
 */
package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class ReverseList {

	public static void sortPancakes(List<Integer> pancakes)
	{
		int toBeSorted = pancakes.size()-1;
		for(int i = 0; i<pancakes.size(); i++){
			toBeSorted = pancakes.size()-1-i;
			int maxPos = maxPosition(pancakes, toBeSorted);
			flip(pancakes, maxPos);
			System.out.println("full flip toBeSorted - "+toBeSorted);
			flip(pancakes, toBeSorted);
		}
	}

	private static int maxPosition(List<Integer> pancakes, int right) {
		int maxPos = pancakes.get(0);
		for(int pos=1; pos<=right; pos++){
			if(pancakes.get(pos) > pancakes.get(maxPos)) maxPos = pos;
		}
		return maxPos;
	} 

	public static void flip(List<Integer> pancakes, int indexToStartFlip)
	{
		System.out.println("\nentry "+Arrays.deepToString(pancakes.toArray())+", index - "+indexToStartFlip);
		int left = 0, right = indexToStartFlip;
		while(left < right){
			int temp = pancakes.get(left);
			pancakes.set(left, pancakes.get(right));
			pancakes.set(right, temp);
			left++;
			right--;
		}
		System.out.println("exit "+Arrays.deepToString(pancakes.toArray()));
	}

	private static void print(List<Integer> list){
		for(Integer i : list){
			System.out.print(i);
		}
		System.out.println();
	}

	@Test
	public void test_01() {
		ArrayList<Integer> pancakes = new ArrayList<Integer>();
		pancakes.add(2);
		pancakes.add(7);
		pancakes.add(5);
		pancakes.add(1);
		pancakes.add(4);
		pancakes.add(2);
		pancakes.add(3);
		pancakes.add(6);
		System.out.print("pre-sort "+Arrays.deepToString(pancakes.toArray()));
		sortPancakes(pancakes);
		System.out.print("post-sort "+Arrays.deepToString(pancakes.toArray()));
	}

}
