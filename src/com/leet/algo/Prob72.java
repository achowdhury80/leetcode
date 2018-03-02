package com.leet.algo;

/**
 * Created by ayanc on 2/22/18.
 */
public class Prob72 {
  public int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) return 0;
    if (word1 == null) return word2.length();
    if (word2 == null) return word1.length();
    int[][] dp = new int[2][word2.length() + 1];
    for (int i = 0; i < word1.length() + 1; i++) {
      int[] temp = dp[1];
      dp[1] = dp[0];
      dp[0] = temp;
      for (int j = 0; j < word2.length() + 1; j++) {
        if (i == 0) dp[1][j] = j;
        else if (j == 0) dp[1][j] = i;
        else {
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[1][j] = dp[0][j - 1];
          else dp[1][j] = Math.min(1 + dp[0][j - 1], Math.min(1 + dp[0][j], 1 + dp[1][j - 1]));
        }
      }
    }
    return dp[1][word2.length()];
  }

  /*public int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) return 0;
    if (word1 == null) return word2.length();
    if (word2 == null) return word1.length();
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < word1.length() + 1; i++) {
      for (int j = 0; j < word2.length() + 1; j++) {
        if (i == 0) dp[i][j] = j;
        else if (j == 0) dp[i][j] = i;
        else {
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
          else dp[i][j] = Math.min(1 + dp[i - 1][j - 1], Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]));
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }*/

  public static void main(String[] args) {
    Prob72 prob72 = new Prob72();
    System.out.println(prob72.minDistance("ayanc", "ryancd"));
    System.out.println(prob72.minDistance("a", "b"));
  }


}
