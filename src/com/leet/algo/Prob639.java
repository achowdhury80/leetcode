package com.leet.algo;

/**
 * Created by ayanc on 12/14/17.
 */
public class Prob639 {
  public int numDecodings(String s) {
    final int MOD = (int)Math.pow(10, 9) + 7;
    if(s == null || s.length() == 0) {
      return 0;
    }
    long e0 = 1, e1 = 0, e2 = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      long f0, f1, f2;
      if (c == '*') {
        f0 = e0 * 9 + e1 * 9 + e2 * 6;
        f1 = e0;
        f2 = e0;
      } else {
        f0 = ((c - '0' == 0) ? 0 : e0) + e1 + (c - '0' < 7 ? e2 : 0);
        f1 = ((c - '0' == 1) ? e0 : 0);
        f2 = ((c - '0') == 2 ? e0 : 0);
      }
      e0 = f0 % MOD;
      e1 = f1;
      e2 = f2;
    }
    return (int)e0;
  }

  public static void main(String[] arhs){
    Prob639 prob639 = new Prob639();
    System.out.println(prob639.numDecodings("2*"));
    System.out.println(prob639.numDecodings("**"));
    System.out.println(prob639.numDecodings("********************"));
  }
}
