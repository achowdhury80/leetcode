package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob268 {
  public int missingNumber(int[] nums) {
    if(nums == null || nums.length == 0) return -1;
    Long length = Long.valueOf(nums.length);
    Long sum = (length * (length + 1))/2;

    for(int i = 0; i < nums.length; i++){
      sum -= nums[i];
    }
    return sum.intValue();
  }
}
