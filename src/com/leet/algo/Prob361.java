package com.leet.algo;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob361 {
  public int maxKilledEnemies(char[][] grid) {
    int m, n;
    if (grid == null || (m = grid.length) < 1 || (n = grid[0].length) < 1) return 0;
    int[][][] dp = new int[m][n][2];
    int result = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 'W') continue;
        if (j - 1 > -1 && grid[i][j - 1] != 'W') dp[i][j][0] = dp[i][j - 1][0];
        else for (int k = j; k < n && grid[i][k] != 'W'; k++) dp[i][j][0] += grid[i][k] == 'E' ? 1 : 0;
        if (i - 1 > -1 && grid[i - 1][j] != 'W') dp[i][j][1] = dp[i - 1][j][1];
        else for (int k = i; k < m && grid[k][j] != 'W'; k++) dp[i][j][1] += grid[k][j] == 'E' ? 1 : 0;
        if (grid[i][j] == '0') result = Math.max(result, dp[i][j][0] + dp[i][j][1]);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob361 prob361 = new Prob361();
    System.out.println(prob361.maxKilledEnemies(new char[][]{
        {'0', 'E', '0', '0'},
        {'E', '0', 'W', 'E'},
        {'0', 'E', '0', '0'}
    }));
  }
}
