package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob647 {
  public int countSubstrings(String s) {
    int result = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j > -1; j--) {
        if (i == j) {
          result++;
          dp[i][j] = true;
        } else {
          if ((i - j < 2 || dp[j + 1][i - 1]) && s.charAt(i) == s.charAt(j)) {
            result++;
            dp[j][i] = true;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob647 prob647 = new Prob647();
    System.out.println(prob647.countSubstrings("abc"));
    System.out.println(prob647.countSubstrings("aaa"));
  }
}
