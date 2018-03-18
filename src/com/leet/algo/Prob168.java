package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob168 {
  public String convertToTitle(int n) {
    if(n < 1) return null;
    String result = "";
    do{
      n = n - 1;
      int remainder = n % 26;
      result = (char) (remainder + 65) + result;
      n = n / 26;
    }while(n > 0);
    return result;
  }
}
