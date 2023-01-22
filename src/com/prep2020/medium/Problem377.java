package com.prep2020.medium;

import java.util.Arrays;

public class Problem377 {
	/**
	 * O(TN) time and O(T) space
	 * @param nums
	 * @param target
	 * @return
	 */
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
        	for (int num : nums) {
        		if (i >= num) dp[i] += dp[i - num];
        		else break;
        	}
        }
        return dp[target];
    }
}
