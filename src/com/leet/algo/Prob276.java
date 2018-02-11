package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob276 {
  public int numWays(int n, int k) {
    if (n < 1 || k == 0) return 0;
    if (n == 1) return k;
    if (n == 2) return k * k;
    if (k == 1) return 0;
    int sameColor = k;
    int diffColor = k * (k - 1);
    for (int i = 2; i < n; i++) {
      int temp = diffColor;
      diffColor = (sameColor + diffColor) * (k - 1);
      sameColor = temp;
    }
    return sameColor + diffColor;
  }

  public static void main(String[] args) {
    Prob276 prob276 = new Prob276();
    System.out.println(prob276.numWays(2, 1));
    System.out.println(prob276.numWays(3, 2));
    System.out.println(prob276.numWays(4, 2));
  }
}
