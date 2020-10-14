package comp.prep2019.less1000;
import java.util.*;
public class Prob89 {
	/**
	 * O(n^2)
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode(int n) {
		/**
		 * consider for first bit filled up
		 * for the second bit, take all the current result data and add them in reverse with additional leftmost bit set to 1
		 */
		List<Integer> result = new ArrayList<>();
		if (n < 1) {
			result.add(0);
			return result;
		}
		result.add(0);
		result.add(1);
		for (int i = 2; i <= n; i++) {
			for (int j = result.size() - 1; j > -1; j--) {
				int next = 1 << (i - 1) | result.get(j);
				result.add(next);
			}
		}
		return result;
    }
}
