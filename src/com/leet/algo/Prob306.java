package com.leet.algo;

import java.math.BigInteger;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob306 {
  public boolean isAdditiveNumber(String num) {
    int n;
    if(num == null || (n = num.length()) < 3) return false;
    int minRight = (n + 2) /3;
    for (int i = 1; i < (n - minRight); i++) {
      for (int j = 0; j < i; j++) {
        if (j > 0 && num.charAt(0) == '0') continue;
        BigInteger first = new BigInteger(num.substring(0, j + 1));
        if (i - j > 1 && num.charAt(j + 1) == '0') continue;
        BigInteger second = new BigInteger(num.substring(j + 1, i + 1));
        if (isValid(first, second, i + 1, num)) return true;
      }
    }
    return false;
  }

  private boolean isValid(BigInteger first, BigInteger second, int start, String num) {
    if (start == num.length()) return true;
    second = second.add(first);
    first = second.subtract(first);
    String sum = second.toString();
    return num.startsWith(sum, start) && isValid(first, second, start + sum.length(), num);
  }

  public static void main(String[] args) {
    Prob306 prob306 = new Prob306();
    System.out.println(prob306.isAdditiveNumber("112358"));
    System.out.println(prob306.isAdditiveNumber("199100199"));
    System.out.println(prob306.isAdditiveNumber("123"));
    System.out.println(prob306.isAdditiveNumber("198019823962"));
  }
}
