package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 11/14/17.
 */
public class Prob442 {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if(nums == null || nums.length == 0) return result;
    Set<Integer> set = new HashSet<>();
    for(int num : nums){
      if(set.contains(num)) result.add(num);
      else set.add(num);
    }
    return result;
  }
}
