package com.leet.algo;

/**
 * Created by ayanc on 2/23/18.
 */
public class Prob389 {
  public char findTheDifference(String s, String t) {
    int diff = 0;
    for(int i = 0; i < t.length(); i++){
      diff += t.charAt(i) - '0';
    }
    if(s != null) {
      for(int i = 0; i < s.length(); i++){
        diff -= (s.charAt(i) - '0');
      }
    }
    return (char)(diff + '0');
  }
}
