package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob441 {
  public int arrangeCoins(int n) {
    return (int)((Math.sqrt(8 * (n + 0l) + 1) - 1) / 2);
  }
}
