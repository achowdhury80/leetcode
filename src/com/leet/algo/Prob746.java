package com.leet.algo;

/**
 * Created by ayanc on 12/20/17.
 */
public class Prob746 {
  public int minCostClimbingStairs(int[] cost) {
    int n;
    if(cost == null || (n = cost.length) < 2) return 0;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 0;
    for(int i = 2; i <= n; i++){
      dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
    }
    return dp[n];
  }

  public static void main(String[] args){
    Prob746 prob746 = new Prob746();
    System.out.println(prob746.minCostClimbingStairs(new int[]{10, 15, 20}));
    System.out.println(prob746.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
  }
}
