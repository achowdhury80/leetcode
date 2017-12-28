package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/26/17.
 */
public class Prob576 {
  public int findPaths(int m, int n, int N, int i, int j) {
    if(m < 1 || n < 1 || N == 0) return 0;
    long[][][] dp = new long[m][n][N + 1];
    IntStream.range(0, m).forEach(x -> IntStream.range(0, n).forEach(y -> IntStream.range(0, N + 1)
        .forEach(z -> dp[x][y][z] = -1)));
    return (int)(findPaths(dp, m, n, N, i, j) % 1000000007);
  }
  private long findPaths(long[][][] dp, int m, int n, int N, int i, int j) {
    if(i < 0 || i >= m || j < 0 || j >= n) return 0l;
    if(N == 0) return 0l;
    if(dp[i][j][N] != -1) return dp[i][j][N];
    if(N == 1){
      long result = 0;
      if(i == 0) result++;
      if(i + 1 == m) result++;
      if(j == 0) result++;
      if(j + 1 == n) result++;
      dp[i][j][N] = result;
      return dp[i][j][N];
    }
    long result = findPaths(dp, m, n, 1, i, j);
    result += findPaths(dp, m, n, N - 1, i + 1, j);
    result += findPaths(dp, m, n, N - 1, i - 1, j);
    result += findPaths(dp, m, n, N - 1, i, j + 1);
    result += findPaths(dp, m, n, N - 1, i, j - 1);
    dp[i][j][N] = result;
    return result;
  }


  public static void main(String[] args){
    Prob576 prob576 = new Prob576();
//    System.out.println(prob576.findPaths(2, 2, 2, 0, 0));
//    System.out.println(prob576.findPaths(2, 2, 1, 0, 0));
//    System.out.println(prob576.findPaths(1, 3, 3, 0, 1));
    System.out.println(prob576.findPaths(36, 5, 50, 15, 3));
  }
}
