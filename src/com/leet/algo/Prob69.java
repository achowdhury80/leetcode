package com.leet.algo;

/**
 * Created by ayanc on 9/18/17.
 */
public class Prob69 {

  public int mySqrt(int x) {
    if(x < 2) return x;
    if(x == 4) return 2;
    long lower = 1;
    long upper = x/2;
    while(lower < upper){
      long mid = (lower + upper) / 2;
      long mul = mid * mid;
      if(mul == x)
        return Long.valueOf(mid).intValue();
      if(mul > x){
        upper = mid - 1;
      } else lower = mid + 1;
    }
    return lower * lower <= x ? Long.valueOf(lower).intValue() : Long.valueOf(lower - 1).intValue();
  }

  public static void main(String[] args){
    System.out.println(new Prob69().mySqrt(2147395599));
  }
}
