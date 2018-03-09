package com.leet.algo;

/**
 * Created by ayanc on 12/13/17.
 */
public class Prob91 {
  //o(n) O(n)
  public int numDecodings(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[2];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;
    for(int i = 2; i <= n; i++) {
      int first = Integer.valueOf(s.substring(i-1, i));
      int second = Integer.valueOf(s.substring(i-2, i));
      int temp = dp[1];
      if(first == 0) {
        dp[1] = 0;
      }
      if(second >= 10 && second <= 26) {
        dp[1] += dp[0];
      }
      dp[0] = temp;
    }
    return dp[1];
  }

  public static void main(String[] arhs){
    Prob91 prob91 = new Prob91();
    System.out.println(prob91.numDecodings("12"));
    System.out.println(prob91.numDecodings("0"));
      System.out.println(prob91.numDecodings("26"));
    System.out.println(prob91.numDecodings("10"));
  }
}
