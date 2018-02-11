package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 2/4/18.
 */
public class Prob467 {
  public int findSubstringInWraproundString(String p) {
    if (p == null || p.equals("")) return 0;
    int n;
    if ((n = p.length()) < 2) return 1;
    int[] count = new int[26];
    int maxSubstringCount = 0;
    for (int i = 0; i < p.length(); i++) {
      if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) maxSubstringCount++;
      else maxSubstringCount = 1;
      count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxSubstringCount);
    }

    int sum = 0;
    for (int i = 0; i < 26; i++) sum += count[i];
    return sum;

  }

  public static void main(String[] args) {
    Prob467 prob467 = new Prob467();
    System.out.println(prob467.findSubstringInWraproundString("a"));
    System.out.println(prob467.findSubstringInWraproundString("cac"));
    System.out.println(prob467.findSubstringInWraproundString("zab"));
  }
}
