package com.leet.algo;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob390 {
  public int lastRemaining(int n) {
    if(n == 1) return 1;
    int next = (lastRemaining(n - 1) + 2) % 2 + 1;
    return 0;
  }
}
