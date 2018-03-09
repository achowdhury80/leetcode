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
    partition(result, s, 0, new ArrayList<>());
    return result;
  }

  private void partition(List<List<String>> result, String s, int start, List<String> temp){
    if (start == s.length()) {
      result.add(new ArrayList<>(temp));
      return;
    }
    for (int i = start; i < s.length(); i++){
      String sub = s.substring(start, i + 1);
      if (isPal(sub)) {
        temp.add(sub);
        partition(result, s, i + 1, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private boolean isPal(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j){
      if (s.charAt(i) != s.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    Prob131 prob131 = new Prob131();
    System.out.println(prob131.partition("aab"));
  }

}
