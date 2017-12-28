package com.leet.algo;

/**
 * Created by ayanc on 12/12/17.
 */
public class Prob516 {
  public int longestPalindromeSubseq(String s) {
    int length;
    if(s == null || (length = s.length()) == 0) return 0;
    int[][] dp = new int[length][length];
    for(int i = length - 1; i > -1; i--){
      dp[i][i] = 1;
    }
    for(int i = length - 1; i > -1; i--){
      for(int j = i + 1; j < length; j++){
        if(s.charAt(i) == s.charAt(j)){
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else{
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][length - 1];
  }
}
