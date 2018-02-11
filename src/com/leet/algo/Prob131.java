package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/7/18.
 */
public class Prob131 {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    if (s == null || s.length() < 1) return result;
    List<List<String>>[] dp = new List[s.length() + 1];
    dp[0] = new ArrayList<>();
    dp[0].add(new ArrayList<>());
    boolean[][] pal = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i + 1] = new ArrayList<>();
      for (int left = 0; left <= i; left++) {
        if (s.charAt(left) == s.charAt(i) && (i - left < 2 || pal[left + 1][i - 1])) {
          pal[left][i] = true;
          String st = s.substring(left, i + 1);
          for (List<String> palList : dp[left]) {
            List<String> newList = new ArrayList<>(palList);
            newList.add(st);
            dp[i + 1].add(newList);
          }
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    Prob131 prob131 = new Prob131();
    System.out.println(prob131.partition("aab"));
  }

}
