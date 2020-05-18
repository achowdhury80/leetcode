package comp.prep2019;

public class Prob279 {
	public int numSquares(int n) {
		if(n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	if (i * i <= n) dp[i * i] = 1;
        	if (dp[i] == 1) continue;
        	dp[i] = Integer.MAX_VALUE;
        	for (int j = 1; j * j < i; j++) {
        		dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
        	}
        }
        return dp[n];
    }
}
