package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob53 {
  public int maxSubArray(int[] nums) {
    if (nums == null) return 0;
    int sum = 0, minSum = 0;
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      minSum = Math.min(minSum, sum);
      result = Math.max(result, sum - minSum);
    }
    return result;
  }
}
