package com.leet.algo;

/**
 * Created by ayanc on 2/22/18.
 */
public class LongestCommonSubsequence {
  public int find(String s1, String s2) {
    int m, n;
    if (s1 == null || (m = s1.length()) < 1 || s2 == null || (n = s2.length()) < 1) return 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) dp[i][j] = 0;
        else {
          if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
          else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    System.out.println(lcs.find("abcd", "xbyd"));
  }
}
