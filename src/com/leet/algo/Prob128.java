package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob128 {
  public int longestConsecutive(int[] nums) {
    if(nums == null || nums.length < 1) return 0;
    if(nums.length == 1) return 1;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> sizeMap = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      if(map.containsKey(nums[i])) continue;
      if(map.containsKey(nums[i] + 1)){
        int parent = find(map, nums[i] + 1);
        map.put(nums[i], parent);
        sizeMap.put(parent, sizeMap.get(parent) + 1);
        if(map.containsKey(nums[i] - 1)){
          map.put(nums[i] - 1, nums[i]);
          sizeMap.put(parent, sizeMap.get(parent) + sizeMap.get(nums[i] - 1));
        }
      } else {
        map.put(nums[i], nums[i]);
        sizeMap.put(nums[i], 1);
        if(map.containsKey(nums[i] - 1)){
          map.put(nums[i] - 1, nums[i]);
          sizeMap.put(nums[i], sizeMap.get(nums[i]) + sizeMap.get(nums[i] - 1));
        }
      }
    }
    return sizeMap.values().stream().max((i, j) -> i.compareTo(j)).get();

  }

  private int find( Map<Integer, Integer> map, int i){
    return map.get(i) == i ? i : find(map, map.get(i));
  }

  public static void main(String[] args){
    Prob128 prob128 = new Prob128();
    //System.out.println(prob128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    //System.out.println(prob128.longestConsecutive(new int[]{1, 2, 0, 1}));
    System.out.println(prob128.longestConsecutive(new int[]{1, 3, 5, 2, 4}));
  }
}
