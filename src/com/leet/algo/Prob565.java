package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob565 {
  public int arrayNesting(int[] nums) {
    if(nums == null || nums.length < 0) return 0;
    if(nums.length == 1) return 1;
    Map<Integer, List<Integer>> map = new HashMap<>();
    int result = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i++){
      result = Math.max(result, arrayNesting(nums, map, i).size());
    }
    return result;
  }

  private List<Integer> arrayNesting(int[] nums, Map<Integer, List<Integer>> map, int index){
    if(map.containsKey(index)) return map.get(index);
    List<Integer> list = new ArrayList<>();
    list.add(nums[index]);
    int k = index;
    k = nums[k];
    while(nums[k] != k && !list.contains(nums[k])){
      list.add(nums[k]);
      k = nums[k];
    }
    map.put(index,list);
    return list;
  }

  public static void main(String[] args){
    Prob565 prob565 = new Prob565();
    System.out.println(prob565.arrayNesting(new int[]{5,4,0,3,1,6,2}));
  }
}
