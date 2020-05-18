package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob634 {
  final int MOD = 1000000007;
  /**
   * check solution
   * dp(n) = (n - 1) * (dp(n -1) + dp(n - 2))
   * @param n
   * @return
   */
  public int findDerangement(int n) {
	  if (n < 3) return n - 1;
	  int[] dp = new int[n + 1];
	  dp[2] = 1;
	  for (int i = 3; i <= n; i++) {
		  dp[i] = (int)(((i - 1l) * (dp[i - 1] + 0l + dp[i - 2])) % MOD);
	  }
	  return dp[n];
  }
  
  /*public int findDerangement(int n) {
  long result = 1;
  for (int i = 1; i <= n; i++)
    result = (i * result % MOD + (i % 2 == 0 ? 1 : -1)) % MOD;
  return (int)result;
}*/



  public static void main(String[] args) {
    Prob634 prob634 = new Prob634();
    //System.out.println(prob634.nCp(3,3));
    System.out.println(prob634.findDerangement(3));
    System.out.println(prob634.findDerangement(4));
  }
}
