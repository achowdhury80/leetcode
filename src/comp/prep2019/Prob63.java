package comp.prep2019;
public class Prob63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	      int m, n;
	      if (obstacleGrid == null || (m = obstacleGrid.length) == 0 || (n = obstacleGrid[0].length) == 0) return 0;
	      if (obstacleGrid[m - 1][n - 1] == 1) return 0;
	      int[] dp = new int[n];
	      dp[n - 1] = 1;
	      for (int i = m - 1; i > -1; i--) {
	        for (int j = n - 1; j > -1; j--) {
	          if (obstacleGrid[i][j] == 1) {
	            dp[j] = 0;
	            continue;
	          }
	          //if (i == m - 1 && j == n - 1) continue;
	          if (j + 1 < n && obstacleGrid[i][j + 1] == 0) dp[j] += dp[j + 1];
	        }
	      }
	      return dp[0];
	    }
}
