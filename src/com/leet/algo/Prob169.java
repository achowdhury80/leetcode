package com.leet.algo;

/**
 * Created by ayanc on 3/6/18.
 */
public class Prob169 {
  public int majorityElement(int[] nums) {
    int count = 0;
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) {
        result = nums[i];
        count++;
      }
      else if (nums[i] == result) count++;
      else count--;
    }
    return result;
  }
}
