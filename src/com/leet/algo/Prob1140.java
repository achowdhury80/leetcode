package com.leet.algo;
import java.util.*;
public class Prob1140 {
	public int stoneGameII(int[] piles) {
		Map<String, Integer> cache = new HashMap<>();
		int[] presum = new int[piles.length];
		presum[0] = piles[0];
		for (int i = 1; i < piles.length; i++) presum[i] = presum[i - 1] + piles[i];
		return helper(1, 0, piles, cache, presum);
    }
	
	private int helper(int m, int i, int[] piles, Map<String, Integer> cache, int[] presum) {
		if (i >= piles.length) return 0;
		String key = m + " " + i;
		if (cache.containsKey(key)) return cache.get(key);
		int max = 0;
		for (int j = 1; j <= 2 * m && i + j - 1 < piles.length; j++) {
			max = Math.max(max, piles[i + j - 1] 
					- (i > 0 ? presum[i - 1] : 0)
					+ piles[piles.length - 1] - piles[i + j - 1]
					- helper(Math.max(m, j), i + j, piles, cache, presum));
		}
		cache.put(key, max);
		return max;
	}
	
	public static void main(String[] args) {
		Prob1140 prob = new Prob1140();
		System.out.println(prob.stoneGameII(new int[] {2, 7, 9, 4, 4}));
	}
}
