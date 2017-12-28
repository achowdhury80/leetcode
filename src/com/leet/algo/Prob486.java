package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob486 {
  public boolean PredictTheWinner(int[] nums) {
    if(nums == null || nums.length == 0) return false;
    return findDiff(nums, 0, nums.length - 1) >= 0;
  }

  private int findDiff(int[] nums, int s, int e){
    return s == e ? nums[e] : Math.max(nums[s] - findDiff(nums, s + 1, e), nums[e] - findDiff(nums, s, e - 1));
  }

}
