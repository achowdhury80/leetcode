package com.leet.algo;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob294 {
  public boolean canWin(String s) {
    if (s.indexOf("++") < 0) return false;
    char[] chars = s.toCharArray();
    return canWin(chars);
  }

  public boolean canWin(char[] chars) {
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] == '+' && chars[i + 1] == '+') {
        chars[i] = '-';
        chars[i + 1] = '-';
        if (!canWin(chars)) {
          chars[i] = '+';
          chars[i + 1] = '+';
          return true;
        }
        chars[i] = '+';
        chars[i + 1] = '+';
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Prob294 prob294 = new Prob294();
    System.out.println(prob294.canWin("++++"));
  }
}
