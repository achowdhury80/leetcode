package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob560 {
  public int subarraySum(int[] nums, int k) {
    int n;
    if(nums == null || (n = nums.length) < 1) return 0;
    if(n == 1) return nums[0] == k ? 1 : 0;
    int[] sums = new int[n];
    sums[0] = nums[0];
    Map<Integer, Integer> map = new HashMap<>();
    map.put(sums[0], 1);
    int result = 0;
    if(nums[0] == k) result++;
    for(int i = 1; i < nums.length; i++){
      sums[i] = nums[i] + sums[i - 1];
      if(sums[i] == k) result++;
      if(map.containsKey(sums[i] - k)) {
        result += map.get(sums[i] - k);
      }
      map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
    }
    return result;
  }

  public static void main(String[] args){
    Prob560 prob560 = new Prob560();
    int n = prob560.subarraySum(new int[]{1, 1, 1}, 2);
    System.out.println(n);
    n = prob560.subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0);
    System.out.println(n);
  }
}
