package comp.prep2019;
public class Prob63 {
	/**
	 * O(MN) time and space
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m, n;
		if (obstacleGrid == null || (m = obstacleGrid.length) == 0 
				|| (n = obstacleGrid[0].length) == 0) return 0;
	    if (obstacleGrid[m - 1][n - 1] == 1) return 0;
	    int[][] dp = new int[m][n];
	    for (int j = 0; j < n; j++) {
	    	if (obstacleGrid[0][j] == 1) break;
	    	dp[0][j] = 1;
	    }
	    for (int i = 0; i < m; i++) {
	    	if (obstacleGrid[i][0] == 1) break;
	    	dp[i][0] = 1;
	    }
	    for (int i = 1; i < m; i++) {
	    	for (int j = 1; j < n; j++) {
	    		if (obstacleGrid[i][j] == 1) continue;
	    		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	    	}
	    }
	    return dp[m - 1][n - 1];
    }
}
