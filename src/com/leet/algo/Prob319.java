package com.leet.algo;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob319 {
  public int bulbSwitch(int n) {
    if(n < 1) return 0;
    int result = 1;
    for(int i = 2; i <= n; i++){
      if(i * i <= n) result += 1;
    }
    return result;
  }
}
