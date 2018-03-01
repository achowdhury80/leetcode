package com.leet.algo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob791 {
  public String customSortString(String S, String T) {
    if(S == null) return T;
    Map<Character, String> map = new LinkedHashMap<>();
    for (char c : S.toCharArray()) {
      map.put(c, "");
    }
    String result = "";
    for (int i = 0; i < T.length(); i++) {
      char c = T.charAt(i);
      if (map.containsKey(c)) map.put(c, map.get(c) + c);
      else result += c;
    }

    for (char key : map.keySet()) {
      result += map.get(key);
    }
    return result;
  }

  public static void main(String[] args) {
    Prob791 prob791 = new Prob791();
    System.out.println(prob791.customSortString("cba", "abcd"));
  }
}
