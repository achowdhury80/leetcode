package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob300 {
	/**
	 * https://leetcode.com/problems/longest-increasing-subsequence/solution/
	 * o(nlogn)
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) len++;
		}
		return len;
	}
	/*
	 * check the other solution
	 */
	public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	dp[i] = 1;
        	for (int j = i - 1; j > -1; j--) {
        		if (nums[j] < nums[i]) {
        			dp[i] = Math.max(dp[i], 1 + dp[j]);
        		}
        	}
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
}
