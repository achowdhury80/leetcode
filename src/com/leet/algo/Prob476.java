package com.leet.algo;

/**
 * Created by ayanc on 3/7/18.
 */
public class Prob476 {
  public int findComplement(int num) {
    int result = 0;
    boolean found = false;
    int mask = 0;
    for (int i = 31; i > -1; i--) {
      if (found) {
        mask = (mask | (1 << i));
      } else if (((1 << i) & num) > 0) {
        found = true;
        mask = (mask | (1 << i));
      }
    }
    return num ^ mask;
  }

  public static void main(String[] args) {
    Prob476 prob476 = new Prob476();
    System.out.println(prob476.findComplement(5));
  }
}
