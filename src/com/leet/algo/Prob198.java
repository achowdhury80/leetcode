package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob198 {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int[] lastSums = new int[]{nums[0], nums[0] > nums[1] ? nums[0] : nums[1]};
    for (int i = 2; i < nums.length; i++) {
      int nextSum = 0;
      if (nums[i] + lastSums[0] > lastSums[1]) nextSum = nums[i] + lastSums[0];
      else nextSum = lastSums[1];
      lastSums[0] = lastSums[1];
      lastSums[1] = nextSum;
    }
    return lastSums[1];
  }
}
