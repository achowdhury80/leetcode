package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/23/17.
 */
public class Prob322 {

  public int coinChange(int[] coins, int amount) {
    int n;
    if(amount == 0 || coins == null || (n = coins.length) == 0) return 0;
    int[][] dp = new int[amount + 1][n + 1];
    Arrays.sort(coins);
    return coinChange(dp, coins, coins.length, amount);

  }

  private int coinChange(int[][] dp, int[] coins, int coinTypes, int amount){
    if(amount == 0 || coinTypes == 0) return -1;
    if(dp[amount][coinTypes] != 0) return dp[amount][coinTypes];
    if(coinTypes == 1) {
      if(amount % coins[0] == 0) {
        dp[amount][1] = amount / coins[0];
        return dp[amount][1];
      }
      return -1;
    }
    if(amount == coins[coinTypes - 1]){
      dp[amount][coinTypes] = 1;
      return dp[amount][coinTypes];
    } else if(amount < coins[coinTypes - 1]){
      dp[amount][coinTypes - 1] =  coinChange(dp, coins, coinTypes - 1, amount);
      dp[amount][coinTypes] = dp[amount][coinTypes - 1];
      return dp[amount][coinTypes];
    }
    int count = coinChange(dp, coins, coinTypes, amount - coins[coinTypes - 1]);
    if(count == -1) {
      dp[amount][coinTypes] = coinChange(dp, coins, coinTypes - 1, amount);
      return dp[amount][coinTypes];
    }
    else {
      dp[amount][coinTypes] = 1 + count;
      return 1 + count;
    }
  }


  public static void main(String[] args){
    Prob322 prob322 = new Prob322();
    System.out.println(prob322.coinChange(new int[] {1, 2, 5}, 11));
    System.out.println(prob322.coinChange(new int[] {2}, 3));
  }
}
