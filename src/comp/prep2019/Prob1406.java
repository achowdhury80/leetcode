package comp.prep2019;
import java.util.*;
public class Prob1406 {
	public String stoneGameIII(int[] stoneValue) {
        int result = helper(stoneValue, 0, new HashMap<>());
        return result > 0 ? "Alice" : (result < 0 ? "Bob" : "Tie");
    }
	
	/**
	 * returns number of more stones Alice will get
	 * @param stoneValue
	 * @param start
	 * @param cache
	 * @return
	 */
	private int helper(int[] stoneValue, int start, Map<Integer, Integer> cache) {
		if (start == stoneValue.length) return 0;
		if (cache.containsKey(start)) return cache.get(start);
		int result = Integer.MIN_VALUE;
		for (int i = start; i < Math.min(stoneValue.length, start + 3); i++) {
			int cur = 0;
			for (int j = start; j <= i; j++) cur += stoneValue[j];
			int othersGain = helper(stoneValue, i + 1, cache);
			result = Math.max(result, cur - othersGain);
		}
		cache.put(start, result);
		return result;
	}
}
