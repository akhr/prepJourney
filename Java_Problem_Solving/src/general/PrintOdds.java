/**
 * @authour Akhash Ramamurthy
 */
package general;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class PrintOdds {
	
    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> res = new ArrayList<>();
        if(l == r || l < 0 || r < 0 || l > r) return res;
        if(l%2 == 0) l += 1;
        for(int i = l; i<=r; i =+ 2){
            res.add(l);
        }
        return res;
    }
    
    @Test
    public void test_01() {
    	int l = 2, r = 5;
    	Integer[] expected = {3,5};
    	List<Integer> res = oddNumbers(l, r);
		assertArrayEquals(expected, oddNumbers(l, r).toArray(new Integer[res.size()]));
    }

}
