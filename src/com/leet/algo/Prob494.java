package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/18/17.
 */
public class Prob494 {
  public int findTargetSumWays(int[] nums, int S) {
    int n;
    if (nums == null || (n = nums.length) == 0) return 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    if ((S + sum) % 2 != 0) return 0;
    int[] dp = new int[(S + sum) / 2 + 1];
    dp[0] = 1;
    //Arrays.sort(nums);
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] <= i) dp[i] += dp[i - nums[j]];
      }
    }
    return dp[dp.length - 1];
  }

  public int findTargetSumWays1(int[] nums, int S) {
    int n;
    if(nums == null || (n = nums.length) == 0) return 0;
    int sum = 0;
    for(int i = 0; i < nums.length; i++){
      sum += nums[i];
    }
    if(S > sum) return 0;
    int[][] dp = new int [2 * sum + 1][n + 1];
    dp[sum + nums[0]][0] = 1;
    dp[sum - nums[0]][0] = dp[sum - nums[0]][0] + 1;
    for(int i = 1; i < n; i++){
      for(int j = 0; j < 2 * sum + 1; j++){
        if(dp[j][i - 1] != 0){
          int nextValue1 = j + nums[i];
          int nextValue2 = j - nums[i];
          //System.out.println(nextValue1);
          dp[nextValue1][i] =  dp[nextValue1][i] + dp[j][i - 1];
          dp[nextValue2][i] =  dp[nextValue2][i] + dp[j][i - 1];
        }

      }
    }

    return dp[S + sum][n - 1];
  }


  public static void main(String[] args){
    Prob494 prob494 = new Prob494();
    System.out.println(prob494.findTargetSumWays(new int[]{1, 1 , 1 , 1, 1 },3));
//    System.out.println(prob494.findTargetSumWays(new int[]{1},2));
//    System.out.println(prob494.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1},1));
  }
}
