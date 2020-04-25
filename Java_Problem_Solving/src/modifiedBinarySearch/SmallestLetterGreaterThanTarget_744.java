/**
 * 
 */
package modifiedBinarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author ramamurthy
 *
 */
public class SmallestLetterGreaterThanTarget_744 {

	public char nextGreatestLetter(char[] letters, char target) {
		int n = letters.length-1;
		if(target < letters[0] || target > letters[n]) 
			return letters[0];

		int left = 0, right = letters.length, mid = 0;;
		while(left < right) {
			mid = left + (right - left)/2;
			if(target > letters[mid]) {
				left = mid + 1;
			} else {
				if(target > letters[mid-1])
					return letters[mid];
				right = mid - 1;
			}
		}
		return letters[mid];
	}

	@Test
	public void test_01() {
		char[] a = {'c', 'f', 'j'};
		char k = 'a';
		char expected = 'c';
		assertEquals(expected, nextGreatestLetter(a,k));
	}

	@Test
	public void test_02() {
		char[] a = {'c', 'f', 'j'};
		char k = 'c';
		char expected = 'f';
		assertEquals(expected, nextGreatestLetter(a,k));
	}

	@Test
	public void test_03() {
		char[] a = {'c', 'f', 'j'};
		char k = 'd';
		char expected = 'f';
		assertEquals(expected, nextGreatestLetter(a,k));
	}

	@Test
	public void test_04() {
		char[] a = {'c', 'f', 'j'};
		char k = 'g';
		char expected = 'j';
		assertEquals(expected, nextGreatestLetter(a,k));
	}

	@Test
	public void test_05() {
		char[] a = {'c', 'f', 'j'};
		char k = 'k';
		char expected = 'c';
		assertEquals(expected, nextGreatestLetter(a,k));
	}
}
