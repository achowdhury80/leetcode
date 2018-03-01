package com.leet.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 11/15/17.
 */
public class Prob451 {
  public String frequencySort(String s) {
    if(s == null || s.length() == 0) return s;
    Map<Character, String> map = new HashMap<>();

    for(int i = 0; i < s.length(); i++){
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), "") + s.charAt(i));
    }
    String[] bucket = new String[s.length() + 1];
    for (char c : map.keySet()) {
      String str = map.get(c);
      int n = str.length();
      if (bucket[n] == null) bucket[n] = "";
      bucket[n] += str;
    }
    String result = "";
    for (int i = bucket.length - 1; i > -1; i--) {
      if (bucket[i] == null) continue;
      result += bucket[i];
    }
    return result;
  }

  public static void main(String[] args){
    Prob451 prob451 = new Prob451();
    System.out.println(prob451.frequencySort("tree"));
    System.out.println(prob451.frequencySort("cccaaa"));
    System.out.println(prob451.frequencySort("Aabb"));
  }

}
