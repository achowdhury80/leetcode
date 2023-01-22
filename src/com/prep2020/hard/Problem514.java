package com.prep2020.hard;
import java.util.*;
public class Problem514 {
	/**
	 * O(M*N) time and space
	 * @param ring
	 * @param key
	 * @return
	 */
	public int findRotateSteps(String ring, String key) {
        return helper(ring, key, 0, 0, new HashMap<>());
    }
	
	private int helper(String ring, String key, int ringStart, int keyStart, Map<Integer, Integer> cache) {
		if (keyStart == key.length()) return 0;
		int cacheKey = (ringStart << 7) | keyStart;
		if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
		for (int i = 0; i < ring.length(); i++) {
			int index = (ringStart + i) % ring.length();
			if (ring.charAt(index) == key.charAt(keyStart)) {
				int cost = Math.min(i, ring.length() - i) + 1;
				cost += helper(ring, key, ringStart + i, keyStart + 1, cache);
				cache.put(cacheKey, Math.min(cache.getOrDefault(cacheKey, Integer.MAX_VALUE), cost));
			}
		}
		return cache.get(cacheKey);
	}
	
	public static void main(String[] args) {
		Problem514 problem = new Problem514();
		System.out.println(problem.findRotateSteps("abcde", "ade"));
	}
}
