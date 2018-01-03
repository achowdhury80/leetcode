package com.leet.algo;

import java.util.List;

/**
 * Created by ayanc on 12/29/17.
 */
public class Prob632 {
  public int[] smallestRange(List<List<Integer>> nums) {
    if(nums == null || nums.size() < 1) return null;
    if(nums.size() == 1) return new int[]{nums.get(0).get(0), nums.get(0).get(nums.get(0).size() - 1)};
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for(int i = 0; i < nums.size(); i++){
      min = Math.min(min, nums.get(i).get(0));
      max = Math.max(max, nums.get(i).get(nums.get(i).size() - 1));
    }
    int[] result = smallestRange(nums, min, max);
    return result;

  }

  private int[] smallestRange(List<List<Integer>> nums, int min, int max) {
    if(min == max) return new int[]{min, max};
    return null;
  }
}
