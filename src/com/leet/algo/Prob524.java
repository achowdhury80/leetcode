package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/11/18.
 */
public class Prob524 {
  public String findLongestWord(String s, List<String> d) {
    String result = "";
    if(s == null || s.length() < 1 || d == null || d.size() < 1) return result;
    Collections.sort(d, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() > o2.length() ? -1 : (o1.length() < o2.length() ? 1 : o1.compareTo(o2));
      }
    });
    Map<Character, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(!map.containsKey(c)) map.put(c, new ArrayList<>());
      map.get(s.charAt(i)).add(i);
    }
    for(String w : d) if(isFound(map, w)) return w;
    return result;
  }

  private boolean isFound(Map<Character, List<Integer>> map, String w){
    int lastPosition = -1;
    for(int i = 0; i < w.length(); i++){
      char c = w.charAt(i);
      if(!map.containsKey(c)) return false;
      boolean found = false;
      for(int j : map.get(c)){
        if(j > lastPosition){
          lastPosition = j;
          found = true;
          break;
        }
      }
      if(!found) return false;
    }
    return true;
  }

  public static void main(String[] args){
    Prob524 prob524 = new Prob524();
    List<String> d = null;
    d = new ArrayList<>();
    d.add("ale");
    d.add("apple");
    d.add("monkey");
    d.add("plea");
    System.out.println(prob524.findLongestWord("apple", d));
    d = new ArrayList<>();
    d.add("a");
    d.add("b");
    d.add("c");
    System.out.println(prob524.findLongestWord("apple", d));
  }
}
