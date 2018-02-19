package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 2/18/18.
 */
public class Prob269 {

  public String alienOrder1(String[] words) {
    Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
    Map<Character, Integer> degree = new HashMap<Character, Integer>();
    String result = "";
    if (words == null || words.length == 0) return result;
    for (String s : words) {
      for (char c : s.toCharArray()) {
        degree.put(c, 0);
      }
    }
    for (int i = 0; i < words.length - 1; i++) {
      String cur = words[i];
      String next = words[i + 1];
      int length = Math.min(cur.length(), next.length());
      for (int j = 0; j < length; j++) {
        char c1 = cur.charAt(j);
        char c2 = next.charAt(j);
        if (c1 != c2) {
          Set<Character> set = new HashSet<Character>();
          if (map.containsKey(c1)) set = map.get(c1);
          if (!set.contains(c2)) {
            set.add(c2);
            map.put(c1, set);
            degree.put(c2, degree.get(c2) + 1);
          }
          break;
        }
      }
    }
    Queue<Character> q = new LinkedList<Character>();
    for (char c : degree.keySet()) {
      if (degree.get(c) == 0) q.add(c);
    }
    while (!q.isEmpty()) {
      char c = q.remove();
      result += c;
      if (map.containsKey(c)) {
        for (char c2 : map.get(c)) {
          degree.put(c2, degree.get(c2) - 1);
          if (degree.get(c2) == 0) q.add(c2);
        }
      }
    }
    if (result.length() != degree.size()) return "";
    return result;
  }
  public String alienOrder(String[] words) {
    if(words == null || words.length < 1) return "";
    Map<Character, Set<Character>> map = new HashMap<>();
    int maxLength = 0;
    for (String s : words) {
      for (char c : s.toCharArray()) {
        map.put(c, new HashSet<>());
      }
    }
    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i];
      String w2 = words[i + 1];
      maxLength = Math.max(maxLength, Math.max(w1.length(), w2.length()));
      for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
        char c1, c2;
        if((c1 = w1.charAt(j)) != (c2 = w2.charAt(j))) {
          map.get(c1).add(c2);
          break;
        }
      }
    }
    if (map.isEmpty()) {
      if (maxLength == 1) return words[0].charAt(0) + "";
      return "";
    }
    List<Character> list = new ArrayList<>();
    if (!checkDagNOrder(map, list)) return "";
    String result = "";
    for (Character character : list) result += character;
    return result;
  }

  private boolean checkDagNOrder(Map<Character, Set<Character>> map, List<Character> list){
    Set<Character> explored = new HashSet<>();
    Set<Character> temp = new HashSet<>();
    for (char key : map.keySet()) {
      if (!explored.contains(key) && !visit(map, list, explored, temp, key)) return false;
    }
    return true;
  }

  private boolean visit(Map<Character, Set<Character>> map, List<Character> list, Set<Character> explored, Set<Character> temp, char node) {
    if (explored.contains(node)) return true;
    if (temp.contains(node)) return false;
    temp.add(node);
    if (map.containsKey(node)) {
      for (char next : map.get(node)) {
        if (!visit(map, list, explored, temp, next)) return false;
      }
    }
    list.add(0, node);
    explored.add(node);
    return true;
  }

  public static void main(String[] args) {
    Prob269 prob269 = new Prob269();
//    System.out.println(prob269.alienOrder(new String[]{"wrt",
//        "wrf",
//        "er",
//        "ett",
//        "rftt"}));
//    System.out.println(prob269.alienOrder(new String[]{"z", "x"}));
//    System.out.println(prob269.alienOrder(new String[]{"z", "x", "z"}));
//    System.out.println(prob269.alienOrder(new String[]{"z", "z"}));
    System.out.println(prob269.alienOrder(new String[]{"zy", "zx"}));
  }
}
