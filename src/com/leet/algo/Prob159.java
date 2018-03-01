package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob159 {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.length() < 1) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int counter = 0;
    int begin = 0;
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
        counter++;
      }
      while (counter > 2) {
        char ch = s.charAt(begin);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 0) {
          counter--;
          map.remove(ch);
        }
        begin++;
      }
      result = Math.max(result, i - begin + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    Prob159 prob159 = new Prob159();
//    System.out.println(prob159.lengthOfLongestSubstringTwoDistinct("eceba"));
//    System.out.println(prob159.lengthOfLongestSubstringTwoDistinct("a"));
//    System.out.println(prob159.lengthOfLongestSubstringTwoDistinct("aa"));
//    System.out.println(prob159.lengthOfLongestSubstringTwoDistinct("aa"));
    System.out.println(prob159.lengthOfLongestSubstringTwoDistinct("abcabcabc"));
  }


}
