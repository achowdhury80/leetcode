package com.leet.algo;

/**
 * Created by ayanc on 11/13/17.
 */
public class Prob537 {
  public String complexNumberMultiply(String a, String b) {
    if(a == null || b == null) return null;
    int aR = Integer.parseInt(a.substring(0, a.indexOf("+")));
    int aC = Integer.parseInt(a.substring(a.indexOf("+") + 1, a.indexOf("i")));
    int bR = Integer.parseInt(b.substring(0, b.indexOf("+")));
    int bC = Integer.parseInt(b.substring(b.indexOf("+") + 1, b.indexOf("i")));
    int resultR = aR * bR - aC * bC;
    int resultC = aR * bC + bR * aC;
    return  resultR + "+" + resultC + "i";
  }
}
