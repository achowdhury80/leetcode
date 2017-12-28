package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 10/18/17.
 */
public class Prob409 {
  public int longestPalindrome(String s) {
    int count = 0;
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < s.length(); i++){
      Character c = s.charAt(i);
      if(set.contains(c)){
        count += 2;
        set.remove(c);
      }else set.add(c);
    }
    if(set.size() > 0) count++;
    return count;
  }
}
