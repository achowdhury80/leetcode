package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/11/18.
 */
public class Prob594 {
  public int findLHS(int[] nums) {
    if(nums == null || nums.length < 1) return 0;
    Map<Long, Integer> map = new HashMap<>();
    int result = 0;
    for(long num : nums){
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for(long num : map.keySet()){
      if(map.containsKey(num + 1)) result = Math.max(result, map.get(num) + map.get(num + 1));
    }
    return result;
  }
}
