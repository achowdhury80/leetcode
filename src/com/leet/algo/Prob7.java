package com.leet.algo;

/**
 * Created by ayanc on 2/21/18.
 */
public class Prob7 {
  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int tail = x % 10;
      int temp = rev * 10 + tail;
      if ((temp - tail) / 10 != rev) return 0;
      rev = temp;
      x /= 10;
    }
    return rev;
  }
  public static void main(String[] args) {
    Prob7 prob7 = new Prob7();
    System.out.println(prob7.reverse(-2147483648));
    System.out.println(prob7.reverse(1));
    System.out.println(prob7.reverse(12));
    System.out.println(prob7.reverse(-12));
    System.out.println(prob7.reverse(10));
    System.out.println(prob7.reverse(1534236469));
    System.out.println(prob7.reverse(Integer.MAX_VALUE));
  }
}
