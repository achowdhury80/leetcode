package com.leet.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/15/18.
 */
public class Prob325 {
  public int maxSubArrayLen(int[] nums, int k) {
    int sum = 0, max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) max = i + 1;
      else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
      if (!map.containsKey(sum)) map.put(sum, i);
    }
    return max;
  }

  public static void main(String[] args) {
    Prob325 prob325 = new Prob325();
    System.out.println(prob325.maxSubArrayLen(new int[]{1, -1, 5, -2 , 3}, 3));
    System.out.println(prob325.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
  }
}
