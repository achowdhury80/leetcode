package com.prep2020.medium;
import java.util.*;
public class Problem1155 {
	public int numRollsToTarget(int n, int k, int target) {
		Map<String, Long> cache = new HashMap<>();
		cache.put("0#0", 1l);
		return (int)helper(n, k, target, cache);
    }
	
	private long helper(int n, int k, int target, Map<String, Long> cache) {
		long mod = (long)(1e9 + 7);
		String key = target + "#" + n;
		if (cache.containsKey(key)) return cache.get(key);
		long result = 0l;
		if (n == 0 || n * k < target || n * 1 > target) {
			result = 0;
			cache.put(key, result);
			return cache.get(key);
		}
		
		for (int i = 1; i <= k; i++) {
			result = (result + helper(n - 1, k, target - i, cache)) % mod;
		}
		cache.put(key, result);
		return cache.get(key);
	}
}
