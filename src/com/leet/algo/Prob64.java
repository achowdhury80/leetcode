package com.leet.algo;

/**
 * Created by ayanc on 12/19/17.
 */
public class Prob64 {
  public int minPathSum(int[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int m = grid.length;
    int n = grid[0].length;
    int[] dp = new int[n];
    //dp[0] = grid[0][0];
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        dp[j] += Math.min(dp[j], j > 0 ? dp[j - 1] : dp[j]) + grid[i][j];
      }
    }
    return dp[n - 1];
  }

  public static void main(String[] args){
    Prob64 prob64 = new Prob64();
    System.out.println(prob64.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
  }
}
