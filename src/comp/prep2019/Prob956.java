package comp.prep2019;

import java.util.Arrays;

public class Prob956 {
	/**
	 * https://leetcode.com/problems/tallest-billboard/discuss/549498/Easy-understanding-3-ways-from-simple-to-difficult-(Java)
	 * @param rods
	 * @return
	 */
	public int tallestBillboard(int[] rods) {
        int sum = 0, n = rods.length;
        for (int i : rods) sum += i;
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j <= sum; j++) {
        		dp[i][j] = dp[i - 1][j];
        		if (j + rods[i - 1] <= sum && dp[i - 1][j + rods[i - 1]] > -1)
        			dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rods[i - 1]] + rods[i - 1]);
        		if (dp[i - 1][Math.abs(j - rods[i - 1])] > -1) 
        			dp[i][j] = Math.max(dp[i][j], dp[i - 1][Math.abs(j - rods[i - 1])] + Math.max(0,  rods[i - 1] - j));
        	}
        }
        return dp[n][0];
    }
}
