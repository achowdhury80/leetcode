package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 12/10/17.
 */
public class Prob525 {
  public int findMaxLength(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    int result = 0;
    for(int i = 0; i < nums.length; i++){
      sum += nums[i] == 0 ? -1 : nums[i];
      if(map.containsKey(sum)) result = Math.max(result, i - map.get(sum));
      else map.put(sum, i);
    }
    return result;
  }

  public static void main(String[] args){
    Prob525 prob525 = new Prob525();
    System.out.println(prob525.findMaxLength(new int[]{0,1}));
    System.out.println(prob525.findMaxLength(new int[]{0,1, 0}));
  }

}
