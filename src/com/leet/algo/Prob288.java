package com.leet.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 2/18/18.
 */
public class Prob288 {
  Map<String, Set<String>> map;
  public Prob288(String[] dictionary) {
    map = new HashMap<>();
    if (dictionary == null) return;
    for (String word : dictionary) {
      if (word == null || word.length() < 1) continue;
      String abv = word.charAt(0) + "";
      if (word.length() > 2) abv += word.length() - 2;
      if (word.length() > 1) {
        abv += word.charAt(word.length() - 1);
      }
      if (!map.containsKey(abv)) map.put(abv, new HashSet<>());
      map.get(abv).add(word);
    }
  }

  public boolean isUnique(String word) {
    if (word == null || word.length() < 1) return true;
    String abv = word.charAt(0) + "";
    if (word.length() > 2) abv += word.length() - 2;
    if (word.length() > 1) {
      abv += word.charAt(word.length() - 1);
    }
    if (!map.containsKey(abv)) return true;
    if (map.get(abv).size() > 1) return false;
    if (map.get(abv).contains(word)) return true;
    return false;
  }

  public static void main(String[] args) {
    Prob288 prob288 = null;
//    prob288 = new Prob288(new String[]{"deer", "door", "cake", "card"});
//    System.out.println(prob288.isUnique("dear"));
//    System.out.println(prob288.isUnique("cart"));
//    System.out.println(prob288.isUnique("cane"));
//    System.out.println(prob288.isUnique("make"));

    prob288 = new Prob288(new String[]{"a"});
    System.out.println(prob288.isUnique(""));

    prob288 = new Prob288(new String[]{""});
    System.out.println(prob288.isUnique(""));

  }
}
