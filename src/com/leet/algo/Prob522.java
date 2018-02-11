package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 2/7/18.
 */
public class Prob522 {
  public int findLUSlength(String[] strs) {
    Arrays.sort(strs, (x, y) -> y.length() - x.length());
    Set<String> ignoredSet = new HashSet<>();
    List<String> candidates = new ArrayList<>();
    int currentLength = 0;
    for (String str : strs) {
      if (candidates.contains(str)) {
        candidates.remove(str);
        if (candidates.isEmpty()) currentLength = 0;
        ignoredSet.add(str);
      } else if (currentLength != 0 && str.length() < currentLength) return currentLength;
      else if (isSubsequence(str, ignoredSet)) continue;
      else {
        candidates.add(str);
        currentLength = str.length();
      }
    }
    return currentLength == 0 ? -1 : currentLength;
  }

  private boolean isSubsequence(String st, Set<String> ignoredSet) {
    if(ignoredSet.isEmpty()) return false;
    for (String s : ignoredSet) if(isSubsequence(s, st)) return true;
    return false;
  }

  private boolean isSubsequence(String biggger, String smaller){
    int j = 0;
    for (int i = 0; i < biggger.length() && j < smaller.length(); ){
      char charFromBigger = biggger.charAt(i);
      char charFromSmaller = smaller.charAt(j);
      if(charFromSmaller == charFromBigger){
        i++;
        j++;
      } else if(charFromSmaller != charFromBigger) i++;
    }
    if (j == smaller.length()) return true;
    return false;
  }

  public static void main(String[] args) {
    Prob522 prob522 = new Prob522();
    System.out.println(prob522.findLUSlength(new String[]{"aba", "cdc", "eae"}));
    System.out.println(prob522.findLUSlength(new String[]{"aaa", "aaa", "aa"}));
  }
}
