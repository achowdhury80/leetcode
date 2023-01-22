package com.prep2020.medium;

import java.util.Arrays;

public class Problem300 {
	/**
	 * https://leetcode.com/problems/longest-increasing-subsequence/solution/
	 * o(nlogn)
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
        int n = nums.length, len = 0;
        int[] dp = new int[n];
        for (int num : nums) {
        	int i = Arrays.binarySearch(dp, 0, len, num);
        	if (i < 0) i = -(i + 1);
        	dp[i] = num;
        	if (i == len) len++;
        }
        return len;
    }
}
