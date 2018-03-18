package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob58 {
  public int lengthOfLastWord(String s) {
    if(s == null || s.length() == 0) return 0;
    String[] strs = s.split(" ");
    if(strs == null || strs.length == 0) return 0;
    return strs[strs.length - 1].length();
  }
}
