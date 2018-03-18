package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if(nums == null || nums.length < 1) return false;
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++){
      if(i - k -1 > -1){
        set.remove(nums[i - k - 1]);
      }
      if(set.contains(nums[i])) return true;
      set.add(nums[i]);
    }
    return false;
  }
}
