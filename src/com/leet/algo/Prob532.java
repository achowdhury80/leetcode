package com.leet.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob532 {
  public int findPairs(int[] nums, int k) {
    if(nums == null || nums.length < 2 || k < 0) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    int result = 0;
    if(k == 0) return  (int)map.values().stream().filter(x -> x > 1).count();
    for(int i : map.keySet()) if(map.containsKey(i + k)) result++;
    return result;
  }

  public static void main(String[] args){
    System.out.println(new Prob532().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    System.out.println(new Prob532().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    System.out.println(new Prob532().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
  }
}
