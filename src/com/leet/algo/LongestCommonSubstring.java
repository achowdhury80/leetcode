package com.leet.algo;

/**
 * Created by ayanc on 2/22/18.
 */
public class LongestCommonSubstring {
  public int find(String w1, String w2){
    int m, n;
    if (w1 == null || (m = w1.length()) < 1 || w2 == null || (n = w2.length()) < 1) return 0;
    int[][] dp = new int[m + 1][n + 1];
    int result = 0;
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) dp[i][j] = 0;
        else {
          if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
            result = Math.max(result, dp[i][j]);
          } else dp[i][j] = 0;
        }
      }
    }
    return result;
  }

  public String findWord(String w1, String w2){
    int m, n;
    if (w1 == null || (m = w1.length()) < 1 || w2 == null || (n = w2.length()) < 1) return "";
    int[][] dp = new int[m + 1][n + 1];
    String result = "";
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) dp[i][j] = 0;
        else {
          if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
            if (dp[i][j] > result.length()){
              result = w1.substring(i - dp[i][j], i);
            }
          } else dp[i][j] = 0;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    System.out.println(lcs.find("abcd", "abc"));
    System.out.println(lcs.find("abcdefghijkl", "xbcmnlfghixtuvab"));
    System.out.println(lcs.findWord("abcd", "abc"));
    System.out.println(lcs.findWord("abcdefghijkl", "xbcmnlfghixtuvab"));
  }
}
