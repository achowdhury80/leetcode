package com.prep2020.medium;
import java.util.*;
public class Problem1908 {
	
	public boolean nimGame(int[] piles) {
        return helper(piles, new HashMap<>());
    }
	
	private boolean helper(int[] piles, Map<Integer, Boolean> cache) {
		int key = findKey(piles);
		if (key == 0) return false;
		if (cache.containsKey(key)) return cache.get(key);
		for (int i = 0; i < piles.length; i++) {
			if (piles[i] == 0) continue;
			for (int j = 1; j <= piles[i]; j++) {
				piles[i] -= j;
				if (!helper(piles, cache)) {
					cache.put(key, true);
					piles[i] += j;
					return true;
				}
				else piles[i] += j;
			}
		}
		cache.put(key, false);
		return false;
	}
	
	private int findKey(int[] piles) {
		int result = 0;
		for (int i = 0; i < piles.length; i++) {
			result = (result << 3) | piles[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem1908 problem = new Problem1908();
		System.out.println(problem.nimGame(new int[] {6, 6}));
	}
}
