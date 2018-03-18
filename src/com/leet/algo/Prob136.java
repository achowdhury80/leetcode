package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob136 {
  public int singleNumber(int[] nums) {
    int result = 0;
    for(int i = 0; i < nums.length; i++){
      result ^= nums[i];
    }
    return result;
  }
}
