package com.leet.algo;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob672 {
  public int flipLights(int n, int m) {
    if(m == 0) return 1;
    if(n == 1) return 2;
    if(n == 2 && m == 1)  return 3;
    if(n == 2) return 4;
    if(m == 1) return 4;
    if(m == 2) return 7;
    return 8;
  }
}
