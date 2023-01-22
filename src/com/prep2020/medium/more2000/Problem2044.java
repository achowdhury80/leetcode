package com.prep2020.medium.more2000;

public class Problem2044 {
	/**
	 * Time O(mn), where m = max(A)
		Space O(m)
	 * https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/discuss/1525309/JavaC%2B%2BPython-DP-solution
	 * @param nums
	 * @return
	 */
	public int countMaxOrSubsets(int[] nums) {
		int[] dp = new int[1 << 17];
        dp[0] = 1;
        int max = 0;
        for (int a : nums) {
        	for (int j = max; j > -1; j--) {
        		dp[j | a] += dp[j];
        	}
        	max |= a;
        }
        return dp[max];
    }
}
