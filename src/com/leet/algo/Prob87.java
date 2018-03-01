package com.leet.algo;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob87 {
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() < 0 || s2.length() < 0 || s1.length() != s2.length()) return false;
    int[] arr = new int[26];

    for (int i = 0; i < s1.length(); i++) arr[s1.charAt(i) - 'a']++;
    for (int i = 0; i < s2.length(); i++) {
      if (arr[s2.charAt(i) - 'a'] == 0) return false;
      arr[s2.charAt(i) - 'a']--;
    }
    return true;
  }
}
