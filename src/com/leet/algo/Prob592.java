package com.leet.algo;

import java.util.stream.Stream;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob592 {
  public String fractionAddition(String expression) {
    String result = "";
    if(expression == null || expression.length() < 1) return result;
    String[] fractions = expression.split("(?=[-+])");
    result = "0/1";
    for(String fraction : fractions){
      result = add(result, fraction);
    }
    return result;
  }

  public String add(String fraction1, String fraction2){
    int[] f1 = Stream.of(fraction1.split("/")).mapToInt(Integer::parseInt).toArray();
    int[] f2 = Stream.of(fraction2.split("/")).mapToInt(Integer::parseInt).toArray();
    int numer = f1[0] * f2[1] + f2[0] * f1[1];
    int denom = f1[1] * f2[1];
    String sign = "";
    if(numer < 0) {
      sign = "-";
      numer *= -1;
    }
    int x = gcd(numer, denom);
    return sign + (numer / x) + "/" + (denom / x);
  }

  public int gcd(int x, int y){
    return x == 0 || y == 0 ? x + y : gcd(y, x% y);
  }
}
