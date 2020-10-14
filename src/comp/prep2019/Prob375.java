package comp.prep2019;

public class Prob375 {
	public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return getMinAmount(dp, 1, n);
    }
	
	private int getMinAmount(int[][] dp, int start, int end) {
		if (start >= end) return 0;
		if (dp[start][end] != 0) return dp[start][end];
		dp[start][end] = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			dp[start][end] = Math.min(dp[start][end], 
					i + Math.max(getMinAmount(dp, start, i - 1), 
							getMinAmount(dp, i + 1, end)));
		}
		return dp[start][end];
	}
}
