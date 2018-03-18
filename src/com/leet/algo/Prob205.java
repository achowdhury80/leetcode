package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob205 {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if (map.containsKey(c1)) {
        if (map.get(c1) != c2) return false;
      } else {
        if (map.values().contains(c2)) return false;
        map.put(c1, c2);
      }
    }
    return true;
  }
}
