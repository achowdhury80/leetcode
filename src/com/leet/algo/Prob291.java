package com.leet.algo;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by ayanc on 2/22/18.
 */
public class Prob291 {
  public boolean wordPatternMatch(String pattern, String str) {
    if (pattern == null || str == null || pattern.length() > str.length()) return false;
    return wordPatternMatch(pattern, str, 0, 0, new String[26]);
  }

  private boolean wordPatternMatch(String pattern, String str, int pStart, int sStart, String[] map) {
    if (pStart > pattern.length() || sStart > str.length()) return false;
    if (pStart == pattern.length() && sStart == str.length()) return true;
    if (pStart == pattern.length() && sStart < str.length() || pStart < pattern.length() && sStart == str.length()) return false;
    char c = pattern.charAt(pStart);
    if (map[c - 'a'] != null) {
      if (str.substring(sStart).startsWith(map[c - 'a'])) return wordPatternMatch(pattern, str, pStart + 1, sStart + map[c - 'a'].length(), map);
      return false;
    }

    for (int j = sStart; j < str.length(); j++) {
      String sub = str.substring(sStart, j + 1);
      if(isAlreadyTaken(map, sub)) continue;
      map[c - 'a'] = sub;
      if (wordPatternMatch(pattern, str, pStart + 1, sStart + sub.length(), map)) return true;
      map[c - 'a'] = null;
    }
    return false;
  }

  private boolean isAlreadyTaken(String[] map, String newWord) {
    for (int i = 0; i < 26; i++) if(newWord.equals(map[i])) return true;
    return false;
  }

  public static void main(String[] args) {
    Prob291 prob291 = new Prob291();
    System.out.println(prob291.wordPatternMatch("abab","redblueredblue"));
    System.out.println(prob291.wordPatternMatch("aaaa","asdasdasdasd"));
    System.out.println(prob291.wordPatternMatch("aabb", "xyzabcxzyabc"));
  }
}
