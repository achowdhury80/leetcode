package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob231 {
  public boolean isPowerOfTwo(int n) {
    if(n <= 0) return false;
    if(n == 1) return true;
    return (1 << 30) % n == 0;
  }
  public boolean isPowerOfTwo1(int n) {
    if(n <= 0) return false;
    if(n == 1) return true;
    return n % 2 != 0 ? false : isPowerOfTwo(n / 2);
  }
}
