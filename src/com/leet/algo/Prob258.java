package com.leet.algo;

/**
 * Created by ayanc on 2/23/18.
 */
public class Prob258 {
  public int addDigits(int num) {
    return 1 + (num - 1) % 9;
  }
}
