package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 12/23/17.
 */
public class Prob523 {
  //O(n)
  public boolean checkSubarraySum(int[] nums, int k) {
    int n;
    if(nums == null || (n = nums.length) < 2 ) return false;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    if (k < 1) k = -k;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (k != 0) sum %= k;
      Integer prev = map.get(sum);
      if (prev != null) {
        if (i - prev > 1) return true;
      }
      else map.put(sum, i);
    }
    return false;

  }

  public static void main(String[] args){
    Prob523 prob523 = new Prob523();
    System.out.println(prob523.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    System.out.println(prob523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
  }
}
