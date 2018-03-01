package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob340 {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k < 1) return 0;
    if (s == null || s.length() < 1) return 0;
    int counter = 0;
    Map<Character, Integer> map = new HashMap<>();
    int begin = 0, result = 0;
    for (int i = 0; i < s.length(); i++) {
      char c= s.charAt(i);
      if (map.containsKey(c) && map.get(c) > 0) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
        counter++;
      }
      while (counter > k) {
        char ch = s.charAt(begin);
        if (map.get(ch) == 1) counter--;
        map.put(ch, map.get(ch) - 1);
        begin++;
      }
      result = Math.max(result, i - begin + 1);
    }
    return result;
  }
}
