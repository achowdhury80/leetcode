package com.leet.algo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob422 {
  public boolean validWordSquare(List<String> words) {
    for (int i = 0; i < words.size(); i++) {
      String word = words.get(i);
      for (int j = 0; j < word.length(); j++) {
        char c = word.charAt(j);
        String otherWord = null;
        if (words.size() <= j || (otherWord = words.get(j)).length() <= i) return false;
        if (c != otherWord.charAt(i)) return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    Prob422 prob422 = new Prob422();
    System.out.println(prob422.validWordSquare(Arrays.asList("abcd",
        "bnrt",
        "crmy",
        "dtye")));
    System.out.println(prob422.validWordSquare(Arrays.asList("abcd",
        "bnrt",
        "crm",
        "dt")));
    System.out.println(prob422.validWordSquare(Arrays.asList("ball",
        "area",
        "read",
        "lady")));
  }
}
