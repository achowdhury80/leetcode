package comp.prep2019.less2000;

public class Prob1223 {
	/**
	 * https://leetcode.com/problems/dice-roll-simulation/discuss/403756/Java-Share-my-DP-solution
	 * @param n
	 * @param rollMax
	 * @return
	 */
	public int dieSimulator(int n, int[] rollMax) {
		long mod = (long)(1e9 + 7);
        long[][] dp = new long[n][7];
        for (int i = 0; i < 6; i++) dp[0][i] = 1;
        dp[0][6] = 6;
        for (int i = 1; i < n; i++) {
        	long sum = 0;
        	for (int j = 0; j < 6; j++) {
        		dp[i][j] = dp[i - 1][6];
        		if (i - rollMax[j] < 0) sum = (sum + dp[i][j]) % mod;
        		else {
        			if (i - rollMax[j] - 1 >= 0) 
        				dp[i][j] = (dp[i][j] - (dp[i - rollMax[j] - 1][6] 
        						- dp[i - rollMax[j] - 1][j])) % mod + mod;
        			else dp[i][j] = (dp[i][j] - 1) % mod;
        			sum = (sum + dp[i][j]) % mod;
        		}
        	}
        	dp[i][6] = sum;
        }
        return (int)dp[n - 1][6];
    }
}
