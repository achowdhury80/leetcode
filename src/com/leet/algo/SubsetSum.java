package com.leet.algo;

/**
 * Created by ayanc on 3/11/18.
 */
public class SubsetSum {
  public boolean isSubsetSum(int[] arr, int sum) {
    if (arr == null) return false;
    boolean[][] dp = new boolean[sum + 1][arr.length + 1];
    for (int i = 1; i < dp.length; i++) dp[i][0] = false;
    for (int i = 0; i <= arr.length; i++) dp[0][i] = true;
    for (int i = 1; i <= sum; i++) {
      for (int j = 1; j <= arr.length; j++) {
        int num = arr[j - 1];
        dp[i][j] = dp[i][j - 1];
        if (i >= num) dp[i][j] |= dp[i - num][j - 1];
      }
    }
    return dp[sum][arr.length];
  }
}
