package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob50 {
  public double myPow(double x, int n) {
    if(x == 0) return 0;
    if(n == 0) return 1;
    long y = n;
    if(y < 0) {
      x = 1 / x;
      y = (-1) * y;
    }
    if(y % 2 == 0) {
      x = x * x;
      y = y/2;
      return myPow(x, (int)y);
    }
    return x * myPow(x, (int)(y - 1));
  }

  public static void main(String[] args){
    Prob50 prob50 = new Prob50();
    System.out.println(prob50.myPow(2.00000, -2147483648));
  }
}
