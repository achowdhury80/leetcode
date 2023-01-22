package com.prep2020.medium;

public class Problem213 {
	/**
	 * O(N) time
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(findMax(nums, 0, n - 2), findMax(nums, 1, n - 1));
    }
	
	private int findMax(int[] nums, int start, int end) {
		if (start == end) return nums[start];
		int[] dp = new int[] {nums[start], Math.max(nums[start], nums[start + 1])};
		for (int i = start + 2; i <= end; i++) {
			int cur = Math.max(dp[0] + nums[i], dp[1]);
			dp[0] = dp[1];
			dp[1] = cur;
		}
		return dp[1];
	}
}
