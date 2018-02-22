package com.leet.algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob76 {
  public String minWindow(String s, String t) {
    if (t == null || "".equals(t)) return t;
    if (s == null || "".equals(s)) return s;
    Map<Character, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
      count++;
    }

    int begin = 0, end = 0, d = Integer.MAX_VALUE;
    int head = 0;
    while (end < s.length()) {
      char c = s.charAt(end++);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) > -1) count--;
      }
      while (count == 0) {
        if (end - begin < d) {
          d = end - (head = begin);
        }
        char lastCh = s.charAt(begin);
        if (map.get(lastCh) != null) {
          if (map.get(lastCh) == 0) {
            count++;
          }
          map.put(lastCh, map.get(lastCh) + 1);
        }
        begin++;
      }
    }
    return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);

  }

  private boolean mapContainsAll( Map<Character, Integer> map1,  Map<Character, Integer> map2) {
    if (map1.size() != map2.size()) return false;
    for (char c : map1.keySet()) {
      if (map1.get(c) > map2.get(c)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Prob76 prob76 = new Prob76();
//    System.out.println(prob76.minWindow("ADOBECODEBANC", "ABC"));
    System.out.println(prob76.minWindow("cabwefgewcwaefgcf", "cae"));
  }
}
