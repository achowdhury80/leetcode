package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob53 {
  public int maxSubArray(int[] nums) {
    if (nums == null) return 0;
    int result = nums[0];
    int sum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sum = sum <= 0 ? nums[i] : sum + nums[i];
      result = Math.max(result, sum);
    }
    return result;
  }
}
