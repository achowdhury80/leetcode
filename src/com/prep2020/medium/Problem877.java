package com.prep2020.medium;
import java.util.*;
public class Problem877 {
	/**
	 * O(N^2) time and space
	 * @param piles
	 * @return
	 */
	public boolean stoneGame(int[] piles) {
        int[] sum = new int[piles.length];
        sum[0] = piles[0];
        for (int i = 1; i < piles.length; i++) {
        	sum[i] = sum[i - 1] + piles[i];
        }
        int collected = helper(piles, 0, piles.length - 1, new HashMap<>(), sum);
        return 2 * collected > sum[sum.length - 1];
    }
	
	private int helper(int[] piles, int start, int end, Map<Integer, Integer> cache, int[] sum) {
		int key = (start << 9) | end;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		if (start == end) {
			cache.put(key, piles[start]);
			return piles[start];
		}
		int total = sum[end] - (start > 0 ? sum[start - 1] : 0);
		int collected = Math.max(total - helper(piles, start + 1, end, cache, sum), total - helper(piles, start, end - 1, cache, sum)); 
		cache.put(key, collected);
		return collected;
	}
}
