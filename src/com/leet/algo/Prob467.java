package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 2/4/18.
 */
public class Prob467 {
  public int findSubstringInWraproundString(String p) {
    if (p == null) return 0;
    int n;
    if ((n = p.length()) < 2) return 1;
    char[] chars = p.toCharArray();
    boolean[][] dp = new boolean[n][n];
    Set<String> unique = new HashSet<>();
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
      unique.add(p.charAt(i) + "");
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n - i; j++) {
        if (dp[j][j + i - 1]) {
          char c = chars[j + i - 1];
          if (c == 'z' && chars[j + i] == 'a' || c + 1 == chars[j + i]) {
            dp[j][j + i] = true;
            unique.add(p.substring(j, j + i + 1));
          }
        }
      }
    }
    return unique.size();

  }

  public static void main(String[] args) {
    Prob467 prob467 = new Prob467();
    System.out.println(prob467.findSubstringInWraproundString("a"));
    System.out.println(prob467.findSubstringInWraproundString("cac"));
    System.out.println(prob467.findSubstringInWraproundString("zab"));
  }
}
