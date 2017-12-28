package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 12/22/17.
 */
public class Prob673 {
  public int findNumberOfLIS(int[] nums) {
    int n;
    if(nums == null || (n = nums.length) == 0) return 0;
    if(n == 1) return 1;
    //dp[i] longest subsequence
    int[][] dp = new int[n + 1][2]; //first one for subset count and second one for unique longest subsequence
    for(int i = n; i > 0; i--){
      dp[i] = new int[]{1, 1};
      for(int j = i + 1; j <= n; j++){
        if(nums[j - 1] > nums[i - 1]){
          if(dp[j][0] > dp[i][0] - 1){
            dp[i][0] = dp[j][0] + 1;
            dp[i][1] = dp[j][1];
          } else if(dp[j][0] == dp[i][0] - 1){
            dp[i][1] += dp[j][1];
          }
        }
      }
    }

    int result = 0;
    int max = 0;
    for(int i = 1; i <= n; i++){
      if(dp[i][0] > max){
        max = dp[i][0];
        result = dp[i][1];
      } else if(dp[i][0] == max){
        result += dp[i][1];
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob673 prob673 = new Prob673();
    System.out.println(prob673.findNumberOfLIS(new int[]{1,3,5,4,7}));
    System.out.println(prob673.findNumberOfLIS(new int[]{2,2,2,2,2}));
  }
}
