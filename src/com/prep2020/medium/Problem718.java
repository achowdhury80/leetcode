package com.prep2020.medium;

public class Problem718 {
	/**
	 * O(m * n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (nums1[i] == nums2[j]) {
        			dp[i + 1][j + 1] = 1 + dp[i][j];
        			result = Math.max(result, dp[i + 1][j + 1]);
        		}
        	}
        }
        return result;
    }
}
