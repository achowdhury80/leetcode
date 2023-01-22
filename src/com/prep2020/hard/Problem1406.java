package com.prep2020.hard;
import java.util.*;
public class Problem1406 {
	/**
	 * O(N) time and space
	 * @param stoneValue
	 * @return
	 */
	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + stoneValue[i];
        int max = helper(sum, 0, new HashMap<>());
        if (max * 2 == sum[n]) return "Tie";
        if (max * 2 > sum[n]) return "Alice";
        return "Bob";
    }
	
	private int helper(int[] sum, int start, Map<Integer, Integer> cache) {
		if (cache.containsKey(start)) return cache.get(start);
		if (start == sum.length - 1) return 0;
		int result = Integer.MIN_VALUE;
		for (int i = start; i < Math.min(start + 3, sum.length - 1); i++) {
			int cur = sum[i + 1] - sum[start];
			cur += (sum[sum.length - 1] - sum[i + 1] - helper(sum, i + 1, cache));
			result = Math.max(result, cur);
		}
		cache.put(start, result);
		return result;
	}
	
	public static void main(String[] args) {
		Problem1406 problem = new Problem1406();
		//System.out.println(problem.stoneGameIII(new int[] {1, 2, 3, 7}));
		System.out.println(problem.stoneGameIII(new int[] {-1, -2, -3}));
	}
}
