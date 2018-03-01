package com.leet.algo;

/**
 * Created by ayanc on 2/27/18.
 */
public class Prob115 {
  public int numDistinct(String s, String t) {
    int m, n;
    if (s == null || (m = s.length()) < 1 || t == null || (n = t.length()) < 1) return 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++){
      dp[i][0] = 1;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (s.charAt(i) == t.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
        } else {
          dp[i + 1][j + 1] = dp[i][j + 1];
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    Prob115 prob115 = new Prob115();
    System.out.println(prob115.numDistinct("rabbbit", "rabbit"));
  }

}
