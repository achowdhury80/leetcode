package com.prep2020.hard;
import java.util.*;
public class Problem1510 {
	/**
	 * O(N*sqrt(N))
	 * @param n
	 * @return
	 */
	public boolean winnerSquareGame(int n) {
		Map<Integer, Boolean> cache = new HashMap<>();
		cache.put(1, true);
		return helper(n, cache);
    }
	
	private boolean helper(int n, Map<Integer, Boolean> cache) {
		if (cache.containsKey(n)) return cache.get(n);
		int start = (int)Math.sqrt(n);
		for (int i = start; i > 0; i--) {
			if (i * i == n || !helper(n - i * i, cache)) {
				cache.put(n, true);
				return true;
			}
		}
		cache.put(n, false);
		return false;
	}
}
