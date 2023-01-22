package com.prep2020.medium.more2000;

public class Problem2022 {
	public int maximumTop(int[] nums, int k) {
		if (nums.length == 1) {
			return k % 2 == 1 ? -1 : nums[0];
		}
        int n = Math.min(nums.length, k + 1);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
        	if (i == k - 1) continue;
        	result = Math.max(result, nums[i]);
        }
        return result == Integer.MIN_VALUE ? - 1 : result;
    }
}
