package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/26/17.
 */
public class Prob576 {
  public int findPaths(int m, int n, int N, int i, int j) {
    if(m < 1 || n < 1 || N <= 0) return 0;
    final int MOD = 1000000007;
    int[][] dp = new int[m][n];
    int[][] directions = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    dp[i][j] = 1;
    int result = 0;
    for (int k = 0; k < N; k++) {
      int[][] temp = new int[m][n];
      for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
          for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
              result = (result + dp[r][c]) % MOD;
            } else {
              temp[nr][nc] = (temp[nr][nc] + dp[r][c]) % MOD;
            }
          }
        }
      }
      dp = temp;
    }
    return result;
  }



  public static void main(String[] args){
    Prob576 prob576 = new Prob576();
    System.out.println(prob576.findPaths(2, 2, 2, 0, 0));
    System.out.println(prob576.findPaths(2, 2, 1, 0, 0));
    System.out.println(prob576.findPaths(1, 3, 3, 0, 1));
    System.out.println(prob576.findPaths(36, 5, 50, 15, 3));
  }
}
