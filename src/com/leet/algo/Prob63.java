package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/22/17.
 */
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

//  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//    int m , n;
//    if(obstacleGrid == null || (m = obstacleGrid.length) == 0 || (n = obstacleGrid[0].length) == 0) return 0;
//    if(obstacleGrid[m - 1][n - 1] == 1) return 0;
//    int[][] dp = new int[m + 1][n + 1];
//    dp[m][n] = 1;
//    for(int i = m; i > 0; i--){
//      for(int j = n; j > 0; j--){
//        if(i == m && j == n) continue;
//        if(obstacleGrid[i - 1][j - 1] == 1) {
//          dp[i][j] = -1;
//          continue;
//        }
//        boolean flag = false;
//        if(i + 1 <= m && dp[i + 1][j] != -1){
//          dp[i][j] += dp[i + 1][j];
//          flag = true;
//        }
//        if(j + 1 <= n && dp[i][j + 1] != -1){
//          dp[i][j] += dp[i][j + 1];
//          flag = true;
//        }
//        if(!flag) dp[i][j] = -1;
//      }
//    }
//    return dp[1][1] == -1 ? 0 : dp[1][1];
//
//  }

  public static void main(String[] args){
    Prob63 prob63 = new Prob63();
    System.out.println(prob63.uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}));
  }
}
