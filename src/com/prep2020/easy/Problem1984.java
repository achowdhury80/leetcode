package com.prep2020.easy;

import java.util.Arrays;

public class Problem1984 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int minimumDifference(int[] nums, int k) {
		int n = nums.length;
		if (k == 1) return 0;
		Arrays.sort(nums);
		int result = Integer.MAX_VALUE;
		for (int i = 0; i + k < n + 1; i++) {
			result = Math.min(result, nums[i + k - 1] - nums[i]);
		}
		return result;
    }
}
