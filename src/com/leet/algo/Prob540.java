package com.leet.algo;

import java.util.stream.Stream;

/**
 * Created by ayanc on 11/14/17.
 */
public class Prob540 {
  public int singleNonDuplicate(int[] nums) {
    int result = 0;
    for(int num : nums){
      result ^= num;
    }
    return result;
  }
}
