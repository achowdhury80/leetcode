package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 2/7/18.
 */
public class Prob187 {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> result = new ArrayList<>();
    if(s == null || s.length() < 11) return result;
    String str = s.substring(0, 10);
    Map<String, Integer> countMap = new HashMap<>();
    countMap.put(str, 1);
    for (int i = 1; i + 9 < s.length()  ; i++) {
      str = (str + s.charAt(i + 9)).substring(1);
      countMap.put(str, countMap.getOrDefault(str, 0) + 1);
    }
    for (String key : countMap.keySet()) {
      if (countMap.get(key) > 1) result.add(key);
    }
    return result;
  }

  public static void main(String[] args) {
    Prob187 prob187 = new Prob187();
    System.out.println(prob187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
  }
}
