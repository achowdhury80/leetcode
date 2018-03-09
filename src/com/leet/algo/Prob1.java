package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 3/4/18.
 */
public class Prob1 {
  public int[] twoSum(int[] nums, int target) {
    if(nums == null || nums.length < 2) return null;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      if(map.containsKey(nums[i])){
        return new int[]{map.get(nums[i]), i};
      } else {
        map.put(target - nums[i], i);
      }
    }
    return null;
  }
}
