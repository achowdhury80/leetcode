package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2189 {
	public int houseOfCards(int n) {
        return helper(n, 500, new HashMap<>());
    }
	
	private int helper(int n, int baseLength, Map<Integer, Integer> cache) {
		if (n == 0) return 1;
		if (baseLength == 0) return 0;
		if (n == 2) return 1;
		int key = (n << 9) | baseLength;
		if (cache.containsKey(key)) return cache.get(key);
		int result = 0;
		int upperBase = 0, lowerBase = 1;
		for (int j = 5; j <= n; j += 3) {
			upperBase++;
			lowerBase++;
			if (lowerBase > baseLength) break;
        	int variations = helper(n - j, upperBase, cache);
        	result += variations;
        }
		cache.put(key, result);
		return cache.get(key);
	}
	
	public static void main(String[] args) {
		Problem2189 problem = new Problem2189();
		System.out.println(problem.houseOfCards(16));
	}
}
