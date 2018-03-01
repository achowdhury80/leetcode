package com.leet.algo;

/**
 * Created by ayanc on 2/22/18.
 */
public class Prob72 {
  public int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) return 0;
    if (word1 == null) return word2.length();
    if (word2 == null) return word1.length();
    return Math.max(word1.length(), word2.length()) - longestCommonSubsequence(word1, word2);
  }

  private int longestCommonSubsequence(String w1, String w2){
    int m, n;
    if ((m = w1.length()) < 1 || (n = w2.length()) < 1) return 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) dp[i][j] = 0;
        else {
          if (w1.charAt(i - 1) == w2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
          else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[m][n];
  }
}
