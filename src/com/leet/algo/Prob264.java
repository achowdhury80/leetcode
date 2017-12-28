package com.leet.algo;

/**
 * Created by ayanc on 12/19/17.
 */
public class Prob264 {
  public int nthUglyNumber(int n) {
    if(n < 1) return 0;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int factor2_mul = 2;
    int factor2_last = 1;
    int factor3_mul = 3;
    int factor3_last = 1;
    int factor5_mul = 5;
    int factor5_last = 1;
    for(int i = 2; i <= n; i++){
      int nextNumber = Math.min(dp[factor2_last] * factor2_mul, Math.min(dp[factor3_last] * factor3_mul, dp[factor5_last] * factor5_mul));
      dp[i] = nextNumber;
      if(nextNumber == dp[factor2_last] * factor2_mul){
        factor2_last++;
      }
      if(nextNumber == dp[factor3_last] * factor3_mul){
        factor3_last++;
      }
      if(nextNumber == dp[factor5_last] * factor5_mul){
        factor5_last++;
      }

    }
    return dp[n];
  }

  public static void main(String[] args){
    Prob264 prob264 = new Prob264();
    //for(int i = 1; i < 14; i++) System.out.println(prob264.nthUglyNumber(i));
    //System.out.println(prob264.nthUglyNumber(1690));
    System.out.println(prob264.nthUglyNumber(1600));
  }
}
