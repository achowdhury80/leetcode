package comp.prep2019.less1000;

public class Prob361 {
	public int maxKilledEnemies(char[][] grid) {
        int m, n;
        if ((m = grid.length) < 1 || (n = grid[0].length) < 1) return 0;
        int[][][] dp = new int[m][n][2];
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 'W') continue;
        		if (j == 0 || grid[i][j - 1] == 'W') {
        			int count = 0;
        			for (int k = j; k < n && grid[i][k] != 'W'; k++) {
        				if (grid[i][k] == 'E') count++;
        			}
        			dp[i][j][0] = count;
        		} else {
        			dp[i][j][0] = dp[i][j - 1][0];
        		}
        		if (i == 0 || grid[i - 1][j] == 'W') {
        			int count = 0;
        			for (int k = i; k < m && grid[k][j] != 'W'; k++) {
        				if (grid[k][j] == 'E') count++;
        			}
        			dp[i][j][1] = count;
        		} else {
        			dp[i][j][1] = dp[i - 1][j][1];
        		}
        		if (grid[i][j] == '0') {
        			result = Math.max(result, dp[i][j][0] + dp[i][j][1]);
        		}
        	}
        }
        return result;
    }
}
