package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob28 {
  public int strStr(String haystack, String needle){
    int l = needle.length();
    for (int i = 0; i + l - 1 < haystack.length(); i++){
      for (int j = 0; ; j++) {
        if (j == l) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
    return -1;
  }
}
