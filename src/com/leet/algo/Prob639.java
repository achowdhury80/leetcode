package com.leet.algo;

/**
 * Created by ayanc on 12/14/17.
 */
public class Prob639 {
  public int numDecodings(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    long[] dp = new long[n+1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : (s.charAt(0) == '*' ? 9 : 1);
    for(int i = 2; i <= n; i++) {
      if(s.charAt(i - 1) == '*'){
        dp[i] += 9 * dp[i - 1];
      } else {
        int first = Integer.valueOf(s.substring(i - 1, i));
        if (first >= 1 && first <= 9) {
          dp[i] += dp[i - 1];
        }
      }
      char firstChar = s.charAt(i - 2);
      char secondChar = s.charAt(i - 1);
      if(firstChar == '*' && secondChar == '*'){
        dp[i] += 15 * dp[i - 2];
      } else if(firstChar == '*'){
          if(secondChar < '7'){
            dp[i] += 2 * dp[i - 2];
          } else {
            dp[i] += dp[i - 2];
          }
      } else if(secondChar == '*'){
          if(firstChar == 1){
            dp[i] += 9 * dp[i - 2];
          } else if(firstChar == 2){
            dp[i] += 6 * dp[i - 2];
          }
      } else {
        int second = Integer.valueOf(s.substring(i - 2, i));
        if (second >= 10 && second <= 26) {
          dp[i] += dp[i - 2];
        }
      }
      dp[i] %= 1000000007;
    }
    return Long.valueOf(dp[n] % 1000000007).intValue();
  }

  public static void main(String[] arhs){
    Prob639 prob639 = new Prob639();
    System.out.println(prob639.numDecodings("2*"));
    System.out.println(prob639.numDecodings("**"));
    System.out.println(prob639.numDecodings("********************"));
  }
}
