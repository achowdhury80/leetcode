package com.leet.algo;

/**
 * Created by ayanc on 12/23/17.
 */
public class Prob523 {
  public boolean checkSubarraySum(int[] nums, int k) {
    int n;
    if(nums == null || (n = nums.length) < 2) return false;
    int[][] dp = new int[n + 1][n + 1];
    for(int i = 1; i <= n; i++){
      dp[i][i] = nums[i - 1];
    }
    for(int j = 1; j < n; j++){
      for(int i = 1; i < n; i++){
        if(i + j > n) break;
        dp[i][i + j] = nums[i - 1] + dp[i + 1][i + j];
        if((k != 0 && dp[i][i + j] % k == 0) || (k == 0 && dp[i][i + j] == k)) return true;
      }
    }
    return false;

  }

  public static void main(String[] args){
    Prob523 prob523 = new Prob523();
    System.out.println(prob523.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    System.out.println(prob523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
  }
}
