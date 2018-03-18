package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob660 {
  public int newInteger(int n) {
    if (n == 0) return 0;
    long count = 0;
    int i = 1;
    int nextSet = 0;
    while (count + nextSet < n) {
      count += nextSet;
      nextSet = (int)(Math.pow(9, i) - Math.pow(9, i - 1));
      i++;
    }
    i--;
    int start = (int)Math.pow(10, i - 1);
    n = n - (int)count;
    return start + newInteger(n - 1);
  }

  public static void main(String[] args) {
    Prob660 prob660 = new Prob660();
    //System.out.println(prob660.newInteger(9));
    System.out.println(prob660.newInteger(800000000));

  }
}
