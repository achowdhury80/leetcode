package com.leet.algo;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob625 {
  public int smallestFactorization(int a) {
    long result = 0;
    if (a < 10) return a;
    long multipy = 1;
    do {
      boolean found = false;
      for (int i = 9; i > 1; i--) {
        if (a % i == 0) {
          found = true;
          result += i * multipy;
          multipy *= 10;
          a = a / i;
          break;
        }
      }
      if (!found) return 0;
    } while (a > 9);
    result = a * multipy + result;
    return result > Integer.MAX_VALUE ? 0 : (int) result;
  }

  public static void main(String[] args) {
    Prob625 prob625 = new Prob625();
    System.out.println(prob625.smallestFactorization(48));
    System.out.println(prob625.smallestFactorization(15));
    System.out.println(prob625.smallestFactorization(1));
    System.out.println(prob625.smallestFactorization(11));
    System.out.println(prob625.smallestFactorization(10));
    System.out.println(prob625.smallestFactorization(18000000));
  }
}
