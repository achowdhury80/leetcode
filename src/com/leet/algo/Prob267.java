package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob267 {
  public List<String> generatePalindromes(String s) {
    int n;
    List<String> list = new ArrayList<>();
    if (s == null || (s.length() < 1)) return list;
    Map<Character, Integer> charMap = new HashMap<>();
    int odd = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      charMap.put(c, charMap.getOrDefault(c, 0) + 1);
      if (charMap.get(c) % 2 == 1) odd++;
      else odd--;
    }
    if (odd > 1) return list;
    String mid = "";
    int length = 0;
    List<Character> set = new ArrayList<>(charMap.keySet());
    for (char c : set){
      int count = charMap.get(c);
      if (count % 2 == 1) {
        mid += c;
        count--;
        if (count == 0) {
          charMap.remove(c);
          continue;
        }
        else charMap.put(c, count);
      }
      charMap.put(c, count / 2);
      length += count / 2;
    }
    permutate(list, mid, length, charMap, new StringBuilder());
    return list;
  }

  private void permutate(List<String> list, String middle, int leftLength, Map<Character, Integer> charMap, StringBuilder sb){
    if (sb.length() == leftLength) {
      list.add(sb.toString() + middle + sb.reverse().toString());
      return;
    }
    List<Character> characters = new ArrayList<>(charMap.keySet());
    for (int i = 0; i < characters.size(); i++) {
      if (charMap.get(characters.get(i)) == 0) continue;
      StringBuilder newSb = new StringBuilder(sb);
      newSb.append(characters.get(i));
      charMap.put(characters.get(i), charMap.get(characters.get(i)) - 1);
      permutate(list, middle, leftLength, charMap, newSb);
      charMap.put(characters.get(i), charMap.get(characters.get(i)) + 1);
    }
  }

  public static void main(String[] args) {
    Prob267 prob267 = new Prob267();
    System.out.println(prob267.generatePalindromes("aabb"));
    System.out.println(prob267.generatePalindromes("abc"));
    System.out.println(prob267.generatePalindromes("civic"));
  }
}
