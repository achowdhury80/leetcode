package comp.prep2019.less2000;

public class Prob1388 {
	/**
	 * https://leetcode.com/problems/pizza-with-3n-slices/discuss/554171/Java-DP-Solution-Clear-Explanation-Clean-code
	 * @param slices
	 * @return
	 */
	public int maxSizeSlices(int[] slices) {
        int m = slices.length, n = m / 3;
        return Math.max(maxSum(slices, 0, m - 2, n), maxSum(slices, 1, m - 1, n));
    }
	
	private int maxSum(int[] slices, int start, int end, int n) {
		int m = end - start + 1;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1) dp[i][j] = slices[start];
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i - 1 + start]);
				}
			}
		}
		return dp[m][n];
	}
}
