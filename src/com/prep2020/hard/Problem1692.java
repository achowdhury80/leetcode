package com.prep2020.hard;
import java.util.*;
public class Problem1692 {
	/**
	 * O(N*K) time and space
	 * @param n
	 * @param k
	 * @return
	 */
	public int waysToDistribute(int n, int k) {
        return helper(n, k, new HashMap<>(), new HashMap<>());
    }
	
	private int helper(int n, int k, Map<Integer, Long> factCache, Map<Integer, Integer> cache) {
		long mod = (long)(1e9 + 7);
		if (n == k || k == 1) return 1;
		int key = (n << 10) | k;
		if (cache.containsKey(key)) return cache.get(key);
		long result = 0;
		for (int i = 1; n - i >= k - 1; i++) {
			result = (((fact(n, i, factCache) % mod) * helper(n - i, k - 1, factCache, cache)) % mod 
					+ result) % mod;
		}
		cache.put(key, (int) result);
		return cache.get(key);
	}
	
	private long fact(int n, int m, Map<Integer, Long> cache) {
		if (n == m || m == 0) return 1;
		int key = (n << 10) | m;
		if (cache.containsKey(key)) return cache.get(key);
		long result = 0;
		result = fact(n - 1, m - 1, cache) + fact(n - 1, m, cache);
		cache.put(key, result);
		return result;
	}
	
	public static void main(String[] args) {
		Problem1692 problem = new Problem1692();
		System.out.println(problem.waysToDistribute(3, 2));
	}
}
