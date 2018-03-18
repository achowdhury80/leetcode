package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob171 {
  public int titleToNumber(String s) {
    if(s == null || s.length() == 0) return 0;
    int j = 1;
    int result = 0;
    for(int i = s.length() - 1; i > -1; i--){
      result += ((int)s.charAt(i) - 64) * j;
      j *= 26;
    }
    return result;
  }
}
