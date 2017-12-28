package com.leet.algo;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob521 {
  public int findLUSlength(String a, String b) {
    if(a == null && b == null) return -1;
    if(a == null || a.length() == 0){
      return b.length() == 0 ? -1 : b.length();
    }
    if(b == null || b.length() == 0){
      return a.length() == 0 ? -1 : a.length();
    }
    if(a.equals(b)) return -1;
    String bigger = a;
    String smaller = b;
    if(a.length() < b.length()){
      bigger = b;
      smaller = a;
    }
    return bigger.length();

  }
}
