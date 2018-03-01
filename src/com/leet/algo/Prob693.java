package com.leet.algo;

/**
 * Created by ayanc on 2/23/18.
 */
public class Prob693 {
  public boolean hasAlternatingBits(int n) {
    if (n < 0) return false;
    int mask = 1 << 30;
    while (mask > 1 && (mask & n) == 0) mask = mask >> 1;
    if (mask == 1) return true;
    boolean cur = true;
    while (mask > 1) {
      mask = mask >> 1;
      if (cur ^ ((n & mask) > 0)) cur = (n & mask) > 0;
      else return false;
    }
    return true;
  }
}
