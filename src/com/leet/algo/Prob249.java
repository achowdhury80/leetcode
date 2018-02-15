package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob249 {
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> result = new ArrayList<>();
    if (strings == null || strings.length < 1) return result;
    Map<String, List<String>> map = new HashMap<>();
    for (String word : strings) {
      String distances = "";
      for (int i = 1; i < word.length(); i++) {
        int d = word.charAt(i) - word.charAt(i - 1);
        if (d < 0) d += 26;
        distances = distances + "," + d;
      }
      if (!map.containsKey(distances)) map.put(distances, new ArrayList<>());
      map.get(distances).add(word);
    }
    for (List<String> list : map.values()) result.add(list);
    return result;
  }

  public static void main(String[] args) {
    Prob249 prob249 = new Prob249();
    System.out.println(prob249.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
  }
}
