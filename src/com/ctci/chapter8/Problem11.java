package com.ctci.chapter8;

import java.util.Arrays;

/**
 * Created by ayanc on 7/23/17.
 */
public class Problem11 {
  private long[] cache = null;
  public long findNumberOfWays(int totalCents){
    if(totalCents < 1) return 0;
    cache = new long[totalCents + 1];
    Arrays.fill(cache, -1);
    cache[0] = 1;
    return compute(totalCents);
  }
  private long compute(int n){
    if(cache[n] > -1) return cache[n];
    if(n > 24) {
      cache[n] = 7 * compute(n - 25);
    } else if(n > 9) {
      cache[n] = 4 * compute(n - 10);
    }else if(n > 4){
      cache[n] = 2 * compute(n - 5);
    } else{
      cache[n] = 1;
    }
    return cache[n];
  }

  public static void main(String[] args){
    System.out.println(new Problem11().findNumberOfWays(200));
  }
}
