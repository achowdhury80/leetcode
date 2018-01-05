package com.leet.algo;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob724 {
  public int pivotIndex(int[] nums) {
    if(nums == null || nums.length == 0) return -1;
    int sums = 0;
    int left = 0;
    for(int i = 0; i < nums.length; i++) sums += nums[i];
    for(int i = 0; i < nums.length; i++){
      if(i != 0) left += nums[i - 1];
      if(sums - left - nums[i] == left) return i;
    }
    return -1;
  }
}
