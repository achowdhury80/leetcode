package comp.prep2019.less1000;
import java.util.*;
public class Prob254 {
	public List<List<Integer>> getFactors(int n) {
		return helper(n, 2);
    }
	
	private List<List<Integer>> helper(int n, int min) {
		List<List<Integer>> result = new ArrayList<>();
		if (n < 4) return result;
		int sqrt = (int)Math.sqrt(n);
		for (int i = Math.max(2, min); i <= sqrt; i++) {
			if (n % i == 0 && n / i >= min) {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				l.add(n / i);
				result.add(l);
				List<List<Integer>> l2 = helper(n / i, i);
				if (!l2.isEmpty()) {
					for (List<Integer> l3 : l2) {
						l3.add(0, i);
						result.add(l3);
					}
				}
			}
		}
		return result;
	}
}
