package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob462 {
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int i = 0, j = nums.length -1, count = 0;
    while(i < j) count += nums[j--] - nums[i++];
    return count;
  }
}
