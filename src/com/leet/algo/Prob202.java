package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob202 {
  Set<Integer> traversed = new HashSet<>();
  public boolean isHappy(int n) {
    if(n == 1) return true;
    traversed.add(n);
    int sum = 0;
    while(n > 0){
      int remainder = n % 10;
      sum += remainder * remainder;
      n = n / 10;
    }
    if(sum == 1) return true;
    if(traversed.contains(sum)) return false;
    return isHappy(sum);
  }
}
