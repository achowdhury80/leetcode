package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob30 {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (s == null || s.length() < 1 || words == null || words.length < 1) return result;
    int length = words[0].length();
    Map<String, Integer> counts = new HashMap<>();
    for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);
    int n = words.length;
    for (int i = 0; i < s.length() - length * n + 1; i++) {
      Map<String, Integer> seen = new HashMap<>();
      int j = 0;
      while (j < n) {
        String sub = s.substring(i + j * length, i + (j + 1) * length);
        if (counts.containsKey(sub)) {
          seen.put(sub, seen.getOrDefault(sub, 0) + 1);
          if (seen.get(sub) > counts.get(sub)) break;
        } else {
          break;
        }
        j++;
      }
      if (j == n) result.add(i);
    }
    return result;
  }
}
