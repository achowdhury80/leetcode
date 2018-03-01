package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob242 {
  public boolean isAnagram(String s, String t) {
    if(s == null || t == null || s.length() != t.length()) return false;
    int[] chars = new int[26];
    for (int i = 0; i < s.length(); i++) chars[s.charAt(i) - 'a']++;
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      if (chars[ch - 'a'] == 0) return false;
      chars[ch - 'a']--;
    }
    return true;
  }
}
