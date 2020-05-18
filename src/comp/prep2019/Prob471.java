package comp.prep2019;

public class Prob471 {
	public String encode(String s) {
		int n = s.length();
        String[][] dp = new String[n][n];
        for (int l = 1; l <= n; l++) {
        	for (int i = 0; i + l - 1 < n; i++) {
        		int j = i + l - 1;
        		dp[i][j] = s.substring(i, j + 1);
        		String now = dp[i][j];
        		for (int k = i; k < j; k++) {
        			if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
        				dp[i][j] = dp[i][k] + dp[k + 1][j];
        			}
        		}
        		int idx = -1;
        		if ((idx = (now + now).indexOf(now, 1)) < now.length()) {
        			now = (now.length() / idx) + "[" + dp[i][i + idx - 1] + "]";
        		}
        		if (now.length() < dp[i][j].length()) dp[i][j] = now;
        	}
        }
        return dp[0][n - 1];
    }
}
