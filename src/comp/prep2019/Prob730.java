package comp.prep2019;

public class Prob730 {
	public int countPalindromicSubsequences(String S) {
		int n = S.length();
		int[][][] dp = new int[4][n][n];
		int mod = (int)1e9 + 7;
		for (int i = n - 1; i > -1; i--) {
			for (int j = i; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					char c = (char)('a' + k);
					if (i == j) {
						if (S.charAt(i) == c) dp[k][i][j] = 1;
					} else {
						if (S.charAt(i) != c) dp[k][i][j] = dp[k][i + 1][j];
						else if (S.charAt(j) != c) dp[k][i][j] = dp[k][i][j - 1];
						else {
							dp[k][i][j] = 2;
							if (j > i + 1) {
								for (int m = 0; m < 4; m++) {
									dp[k][i][j] += dp[m][i + 1][j - 1];
									dp[k][i][j] %= mod;
								}
							}
						}
					}
				}
			}
		}
		int result = 0;
		for (int k = 0; k < 4; k++) {
			result += dp[k][0][n - 1];
			result %= mod;
		}
		return result;
	}
}
