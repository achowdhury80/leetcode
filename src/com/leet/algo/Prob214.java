package com.leet.algo;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob214 {
  public String shortestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;
    int i = (s.length() - 1) / 2;
    int j = s.length() / 2;
    boolean flag = true;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        flag = false;
        break;
      }
    }
    if (flag) return s;
    String result = "";
    int mid = (s.length() - 1) / 2;
    if (s.length() % 2 == 1) mid--;
    return "";
  }
}
