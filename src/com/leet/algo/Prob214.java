package com.leet.algo;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob214 {
  public String shortestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;
    String r = new StringBuilder(s).reverse().toString();
    for (int i = 0; i < r.length(); i++) {
      if (s.startsWith(r.substring(i))) return r.substring(0, i) + s;
    }
    return r + s;
  }


}
