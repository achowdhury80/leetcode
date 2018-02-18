package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob737 {
  public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
    if (words1.length != words2.length) return false;
    Map<String, String> map = populateMap(pairs);
    for (int i = 0; i < words1.length; i++) {
      if (!words1[i].equals(words2[i])) {
        String p0 = findParent(map, words1[i]);
        String p1 = findParent(map, words2[i]);
        if (p0 == null || p1 == null) return false;
        if (!p0.equals(p1)) return false;
      }
    }
    return true;
  }

  private Map<String, String> populateMap(String[][] pairs) {
    Map<String, String> map = new HashMap<>();
    if (pairs == null || pairs.length < 1) return map;
    for (String[] pair : pairs) {
      String p0 = findParent(map, pair[0]);
      String p1 = findParent(map, pair[1]);
      if (p0 == null && p1 == null) {
        map.put(pair[0], pair[0]);
        map.put(pair[1], pair[0]);
      } else if (p0 == null || p1 == null) {
        map.put(p0 == null ? pair[0] : pair[1], p0 == null ? p1 : p0);
      } else if (!p0.equals(p1)) {
        map.put(p1, p0);
      }
    }
    return map;
  }

  private String findParent(Map<String, String> map, String word) {
    if (!map.containsKey(word)) return null;
    while (!word.equals(map.get(word))) word = map.get(word);
    return word;
  }

  public static void main(String[] args) {
    Prob737 prob737 = new Prob737();
    System.out.println(prob737.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"},
        new String[]{"fine", "drama", "talent"},
        new String[][]{{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}}));
  }
}
