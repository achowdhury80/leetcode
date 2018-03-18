package com.leet.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob217 {
  public boolean containsDuplicate(int[] nums) {
    if(nums == null || nums.length == 0) return false;
    Arrays.sort(nums);
    for(int i = 1; i < nums.length; i++){
      if (nums[i] == nums[i - 1]) return true;
    }
    return false;
  }
  public boolean containsDuplicate1(int[] nums) {
    if(nums == null || nums.length == 0) return false;
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++){
      if(set.contains(nums[i])) return true;
      set.add(nums[i]);
    }
    return false;
  }
}
