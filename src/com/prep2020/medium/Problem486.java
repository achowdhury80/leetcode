package com.prep2020.medium;

public class Problem486 {
	/**
	 * O(N^2) time and space
	 * @param nums
	 * @return
	 */
	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = nums[i] + sum[i];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (j + i - 1 > n) break;
        		if (i == 1) dp[j][j] = nums[j - 1];
        		else {
        			dp[j][j + i - 1] = Math.max(nums[j - 1] + (total(sum, j + 1, j + i - 1) - dp[j + 1][j + i - 1]), nums[j + i - 2] + (total(sum, j, j + i - 2) - dp[j][j + i - 2]));
        		}
        	}
        }
        
        return 2 * dp[1][n] >= sum[n];
    }
	
	private int total(int[] sum, int start, int end) {
		return sum[end] - sum[start - 1];
	}
	
	public static void main(String[] args) {
		Problem486 problem = new Problem486();
		//System.out.println(problem.PredictTheWinner(new int[] {1, 5, 2}));
		System.out.println(problem.PredictTheWinner(new int[] {1, 5, 2, 4, 6}));
	}
}
