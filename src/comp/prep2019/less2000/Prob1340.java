package comp.prep2019.less2000;
import java.util.*;
public class Prob1340 {
	/**
	 * dfs + memoriztion
	 * O(N) space
	 * O(nd) time
	 * @param arr
	 * @param d
	 * @return
	 */
	public int maxJumps(int[] arr, int d) {
        Map<Integer, Integer> cache = new HashMap<>();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
        	result = Math.max(result, helper(i, arr, d, cache));
        }
        return result;
    }
	
	private int helper(int idx, int[] arr, int d, Map<Integer, Integer> cache) {
		if (cache.containsKey(idx)) return cache.get(idx);
		int result = 1;
		int i = idx - 1;
		while(i >= Math.max(idx - d, 0)) {
			if (arr[idx] <= arr[i]) break;
			result = Math.max(result, 1 + helper(i, arr, d, cache));
			i--;
		}
		i = idx + 1;
		while(i <= Math.min(idx + d, arr.length - 1)) {
			if (arr[idx] <= arr[i]) break;
			result = Math.max(result, 1 + helper(i, arr, d, cache));
			i++;
		}
		cache.put(idx, result);
		return result;
	}
}
