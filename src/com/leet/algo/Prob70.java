package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 3/3/18.
 */
public class Prob70 {
  public int climbStairs(int n) {
    if (n < 4) return n;
    return climbStairs(n, new HashMap<>());
  }

  public int climbStairs(int n, Map<Integer, Integer> map){
    if (n < 4) return n;
    if (map.containsKey(n)) return map.get(n);
    int result = climbStairs(n / 2) * climbStairs(n - n / 2) + climbStairs(n / 2 - 1) * climbStairs(n - n / 2 - 1);
    map.put(n, result);
    return result;
  }
}
