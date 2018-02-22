package com.leet.algo;

/**
 * Created by ayanc on 2/21/18.
 */
public class Prob7 {
  public int reverse(int x) {
    int multiplyFactor = 1;
    long y = x;
    if(x < 0) {
      multiplyFactor = -1;
      y = y * (-1);
    }
    return  (int)(Long.parseLong(new StringBuilder("" + y).reverse().toString()) * multiplyFactor);
  }
  public static void main(String[] args) {
    Prob7 prob7 = new Prob7();
    System.out.println(prob7.reverse(-2147483648));
  }
}
