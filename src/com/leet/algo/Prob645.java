package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob645 {
  public int[] findErrorNums(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++){
      if (nums[Math.abs(nums[i]) - 1] < 0) result[0] = Math.abs(nums[i]);
      else nums[Math.abs(nums[i]) - 1] = 0 - nums[Math.abs(nums[i]) - 1];
    }
    for (int i = 0; i < nums.length; i++){
      if (nums[i] > 0) {
        result[1] = i + 1;
      }
    }
    return result;
  }
}
