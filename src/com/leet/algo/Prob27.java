package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob27 {
  public int removeElement(int[] nums, int val) {
    if(nums == null || nums.length < 1) return 0;
    int length = nums.length;
    int i = 0;
    while (i < length){
      if(nums[i] != val) i++;
      else nums[i] = nums[--length];
    }
    return length;
  }
}
