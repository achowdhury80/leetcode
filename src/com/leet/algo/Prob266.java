package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob266 {
  public boolean canPermutePalindrome(String s) {
    Map<Character, Boolean> oddMap = new HashMap<>();
    if (s == null || s.length() < 1) return false;
    int oddCount = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      oddMap.put(c, oddMap.getOrDefault(c, false) ^ true);
      if (oddMap.get(c)) oddCount++;
      else oddCount--;

    }
    if (oddCount > 1 || oddCount != s.length() % 2)  return false;
    return true;
  }

  public static void main(String[] args) {
    Prob266 prob266 = new Prob266();
    System.out.println(prob266.canPermutePalindrome("code"));
    System.out.println(prob266.canPermutePalindrome("aab"));
    System.out.println(prob266.canPermutePalindrome("carerac"));
  }
}
