package com.prep2020.medium;

import java.util.Arrays;

public class Problem1508 {
	/**
	 * O(n^2)log(n^2)
	 * @param nums
	 * @param n
	 * @param left
	 * @param right
	 * @return
	 */
	public int rangeSum(int[] nums, int n, int left, int right) {
        int[] cumulative = new int[n + 1];
        for (int i = 0; i < n; i++) cumulative[i + 1] = cumulative[i] + nums[i];
        int[] sums = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = i; j < n; j++) {
        		sums[idx++] = cumulative[j + 1] - cumulative[i];
        	}
        }
        Arrays.sort(sums);
        int result = 0;
        for (int i = left - 1; i < right; i++) 
        	result = (int)((result + sums[i]) % (1e9 + 7));
        return result;
    }
}
