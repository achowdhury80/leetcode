package comp.prep2019;

public class Prob562 {
	public int longestLine(int[][] M) {
		int m, n;
		if ((m = M.length) < 1 || (n = M[0].length) < 1) return 0;
		int[][][] dp = new int[m][n][4];
	    int max = 0;
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	          if (M[i][j] == 1){
	            dp[i][j][0] = j > 0 ? 1 + dp[i][j - 1][0] : 1;
	            max = Math.max(max, dp[i][j][0]);
	            dp[i][j][1] = i > 0 ? 1 + dp[i - 1][j][1] : 1;
	            max = Math.max(max, dp[i][j][1]);
	            dp[i][j][2] = i > 0 && j > 0? 1 + dp[i - 1][j - 1][2] : 1;
	            max = Math.max(max, dp[i][j][2]);
	            dp[i][j][3] = i > 0 && j < n - 1? 1 + dp[i - 1][j + 1][3] : 1;
	            max = Math.max(max, dp[i][j][3]);
	          }
	        }
	      }
	    return max;
	}
}
