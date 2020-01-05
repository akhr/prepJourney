/**
 * @fileName: LC703_KthLargest_Test.java
 * @author: ramamurthy
 * @CreatedOn: Jan 5, 2020
 * 
 */
package heap.LC703_KthLargest;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @fileName: LC703_KthLargest_Test.java
 * @author: ramamurthy
 * @Created on: Jan 5, 2020
 * 
 */
public class LC703_KthLargest_Test {

	@Test
	public void Test_0() {
		int[] a = new int[]{4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, a);
		assertEquals(4, kthLargest.add(3));   // returns 4
		assertEquals(kthLargest.add(5), 5);   // returns 5
		assertEquals(kthLargest.add(10), 5);  // returns 5
		assertEquals(kthLargest.add(9), 8);   // returns 8
		assertEquals(kthLargest.add(4), 8);   // returns 8
	}
}
