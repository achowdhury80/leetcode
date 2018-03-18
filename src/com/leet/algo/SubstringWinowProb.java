package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 3/11/18.
 */
public class SubstringWinowProb {
  public int minWindow(String s, String t) {
    if (s == null || t == null) return 0;
    int begin = 0, end = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    int d = Integer.MAX_VALUE;
    int counter = t.length();
    int head = -1;
    while (end < s.length()) {
      char c = s.charAt(end++);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) > -1) counter--;
      }
      while (counter == 0 && begin < s.length()) {
        if (d > end - begin) d = end - (head = begin);
        char b = s.charAt(begin);
        if (map.containsKey(b)) {
          map.put(b, map.get(b) + 1);
          if (map.get(b) > 0) counter++;
        }
        begin++;
      }
    }
    return d == Integer.MAX_VALUE ? 0 : d;
  }

  public int maxWinDowWithoutRepeat(String s) {
    if (s == null || "".equals(s)) return 0;
    int begin = 0, end = 0;
    Map<Character, Integer> map = new HashMap<>();
    int counter = 0;
    int d = Integer.MIN_VALUE;
    while (end < s.length()) {
      char c = s.charAt(end++);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.get(c) > 1) counter++;
      while (counter > 0) {
        char ch = s.charAt(begin);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) > 0) counter--;
        begin++;
      }
      d = Math.max(d, end - begin);
    }
    return d;
  }

  public int maxWindowAtMost2(String s) {
    if (s == null || "".equals(s)) return 0;
    int begin = 0, end = 0;
    Map<Character, Integer> map = new HashMap<>();
    int d = 0;
    int counter = 0;
    while (end < s.length()) {
      char c = s.charAt(end++);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
        counter++;
      }
      while (counter > 2) {
        char b = s.charAt(begin);
        map.put(b, map.get(b) - 1);
        if (map.get(b) == 0) {
          counter--;
          map.remove(b);
        }
        begin++;
      }
      d = Math.max(d, end - begin);
    }
    return d;
  }
}
