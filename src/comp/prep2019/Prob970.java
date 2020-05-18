package comp.prep2019;
import java.util.*;
public class Prob970 {
	/**
	 * O(N) time and o(logx Bound + logy bound) space
	 * @param x
	 * @param y
	 * @param bound
	 * @return
	 */
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		if (bound < 2) return new ArrayList<>();
		if (x + y == 2) {
			return Arrays.asList(2);
		}
		// if x is 1 then swap
		if (x == 1) {
			x = y;
			y = 1;
		}
		Set<Integer> result = new HashSet<>();
		/**
		 * raise xVal by x in each step
		 * in each step, raise yval from 1 to multiplied by y unless less than bound
		 */
		for (int i = 1; i < bound; i *= x) {
        	for (int j = 1; i + j <= bound; j *= y) {
        		result.add(i + j);
        		if(y == 1) break;
        	}
        }
        return new ArrayList<>(result);
    }
}
