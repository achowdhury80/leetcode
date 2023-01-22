package com.prep2020.medium;
import java.util.*;
public class Problem1066 {
	/**
	 * O(N * M)
	 * @param workers
	 * @param bikes
	 * @return
	 */
	public int assignBikes(int[][] workers, int[][] bikes) {
        return helper(workers, bikes, 0, 0, new HashMap<>());
    }
	
	private int helper(int[][] workers, int[][] bikes, int used, int start, Map<Integer, Integer> cache) {
		if (start == workers.length) return 0;
		int key = (start << 10) | used;
		if (cache.containsKey(key)) return cache.get(key);
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < bikes.length; i++) {
			if (((used >> i) & 1) == 0) {
				result = Math.min(result,  Math.abs(workers[start][0] - bikes[i][0]) + Math.abs(workers[start][1] - bikes[i][1])
					+ helper(workers, bikes, used | (1 << i), start + 1, cache));
			}
		}
		cache.put(key, result);
		return cache.get(key);
	}
}
