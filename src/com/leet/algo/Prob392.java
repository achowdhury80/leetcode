package com.leet.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 12/12/17.
 */
public class Prob392 {
  public boolean isSubsequence(String s, String t){
    if (s.length() == 0) return true;
    int indexS = 0, indexT = 0;
    while (indexT < t.length()) {
      if (s.charAt(indexS) == t.charAt(indexT)) {
        indexS++;
        if (indexS == s.length()) return true;
      }
      indexT++;
    }
    return false;
  }
//  public boolean isSubsequence(String s, String t) {
//    if(s == null || t == null) return false;
//    if(t.equals(s)) return true;
//    if(t.length() == 0) return false;
//    if(s.length() == 0) return true;
//    Map<Character, List<Integer>> map = new HashMap<>();
//    for(int i = 'a'; i <= 'a' + 25; i++){
//      map.put((char)i, new ArrayList<>());
//    }
//    for(int i = 0; i < t.length(); i++){
//      map.get(t.charAt(i)).add(i);
//    }
//    for(int i = 'a'; i <= 'a' + 25; i++){
//      Collections.sort(map.get((char)i));
//    }
//    int pos = -1;
//    for(int i = 0; i < s.length(); i++){
//      List<Integer> list = map.get(s.charAt(i));
//      boolean found = false;
//      for(int j : list){
//        if(j > pos){
//          pos = j;
//          found = true;
//          break;
//        }
//      }
//      if(!found) return false;
//    }
//    return true;
//  }

  public static void main(String[] args){
    Prob392 prob392 = new Prob392();
    System.out.println(prob392.isSubsequence("abc", "ahbgdc"));
    System.out.println(prob392.isSubsequence("axc", "ahbgdc"));
  }
}
