package com.leet.algo;

/**
 * Created by ayanc on 12/19/17.
 */
public class Prob96 {
  public int numTrees(int n) {
    if(n < 1) return 0;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
      for(int j = 0; j < i; j++){
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }

  public static void main(String[] args){
    Prob96 prob96 = new Prob96();
    System.out.println(prob96.numTrees(0));
    System.out.println(prob96.numTrees(1));
    System.out.println(prob96.numTrees(2));
    System.out.println(prob96.numTrees(3));
    System.out.println(prob96.numTrees(4));
  }
}
