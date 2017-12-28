package com.leet.algo;

/**
 * Created by ayanc on 12/15/17.
 */
public class Prob279 {
  public int numSquares(int n){
    if(n < 1) return 0;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
      int min = Integer.MAX_VALUE;
      for(int j = 1; j * j <= i; j++){
        if(dp[i - j * j] + 1 < min ){
          min = dp[i - j * j] + 1;
        }
      }
      dp[i] = min;
    }
    return dp[n];
  }

  public static void main(String[] args){
    Prob279 perfectSquare = new Prob279();
    System.out.println(perfectSquare.numSquares(12));
  }
}
