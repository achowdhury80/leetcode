package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/23/17.
 */
public class Prob322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - coins[j]]  + 1);
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
//  public int coinChange(int[] coins, int amount) {
//    int n;
//    if(amount == 0 || coins == null || (n = coins.length) == 0) return 0;
//    return helper(coins, amount, new int[amount]);
//  }
//
//  private int helper(int[] coins, int remaining, int[] count){
//    if (remaining < 0) return -1;
//    if (remaining == 0) return 0;
//    if (count[remaining -1] != 0) return count[remaining - 1];
//    int min = Integer.MAX_VALUE;
//    for (int coin : coins) {
//      int res = helper(coins, remaining - coin, count);
//      if (res != -1 && res < min) {
//        min = res + 1;
//      }
//    }
//    count[remaining - 1] = min == Integer.MAX_VALUE ? -1 : min;
//    return count[remaining - 1];
//  }


  public static void main(String[] args){
    Prob322 prob322 = new Prob322();
    System.out.println(prob322.coinChange(new int[] {1, 2, 5}, 11));
    System.out.println(prob322.coinChange(new int[] {2}, 3));
    System.out.println(prob322.coinChange(new int[] {186,419,83,408}, 6249));
  }
}
