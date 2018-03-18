package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob290 {
  public boolean wordPattern(String pattern, String str) {
    if(pattern == null || str == null) return false;
    if(pattern.length() == 0 && str.length() == 0) return true;
    if(pattern.length() == 0 || str.length() == 0) return false;
    String[] strs = str.split(" ");
    if(pattern.length() != strs.length) return false;
    Map<Character, String> map = new HashMap<>();
    for(int i = 0; i < pattern.length(); i++){
      if(map.containsKey(pattern.charAt(i))){
        if(!map.get(pattern.charAt(i)).equals(strs[i])) return false;
      } else {
        if(map.values().contains(strs[i])) return false;
        map.put(pattern.charAt(i),strs[i]);
      }
    }
    return true;
  }
}
