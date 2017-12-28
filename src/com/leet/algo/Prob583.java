package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob583 {
  public int minDistance(String word1, String word2) {
    if(word1 == null || word2 == null || word1.equals(word2)) return 0;
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    dp[0][0] = 0;
    IntStream.range(1, word1.length() + 1).forEach(i -> {
      IntStream.range(1, word2.length() + 1).forEach(j -> {
        dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
      });
    });
    int cmn = dp[word1.length()][word2.length()];
    return word1.length() + word2.length() - 2 * cmn;
  }

  public static void main(String[] args){
    Prob583 prob583 = new Prob583();
    System.out.println(prob583.minDistance("sea", "eat"));
  }
}
