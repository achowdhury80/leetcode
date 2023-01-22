package com.prep2020.medium;
import java.util.*;
public class Problem813 {
	/**
	 * O(N * K)
	 * @param nums
	 * @param k
	 * @return
	 */
	public double largestSumOfAverages(int[] nums, int k) {
		int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = nums[i] + sum[i];
        Map<Integer, Double> cache = new HashMap<>();
        return helper(sum, 1, k, cache);
    }
	
	private double helper(int[] sum, int start, int k, Map<Integer, Double> cache) {
		if (start == sum.length) return 0;
		int key = (start << 7) | k;
		if (cache.containsKey(key)) return cache.get(key);
		if (start == sum.length - 1) {
			cache.put(key, 0.0 + sum[start] - sum[start - 1]);
		} else if (k == 1) {
			cache.put(key, (0.0 + sum[sum.length - 1] - sum[start - 1]) / (sum.length - start));
		} else {
			double avgSum = Double.MIN_VALUE;
			for (int i = start; i < sum.length - 1; i++) {
				avgSum = Math.max(avgSum, (0.0 + sum[i] - sum[start - 1]) / (i - start + 1) + helper(sum, i + 1, k - 1, cache));
			}
			cache.put(key, avgSum);
		}
		return cache.get(key);
	}
}
