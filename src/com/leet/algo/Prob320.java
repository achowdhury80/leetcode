package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob320 {
  public List<String> generateAbbreviations(String word) {
    List<String> result = new ArrayList<>();
    result.add(word);
    for (int i = 0; i < word.length(); i++) {
      String left = "";
      if (i > 0) left = word.substring(0, i);
      if (i < word.length() - 1) {
        List<String> subResult = generateAbbreviations(word.substring(i + 1));
        for (String w : subResult) {
          if (Character.isDigit(w.charAt(0))){
            int j = 1;
            while (j < w.length() && Character.isDigit(w.charAt(j))) j++;
            int count = Integer.parseInt(w.substring(0, j)) + 1;
            result.add(left + count + (w.length() == j ? "" : w.substring(j)));
          } else {
            result.add(left + "1" + w);
          }
        }
      } else {
        result.add((word.length() == 1 ? "" : word.substring(0, i)) + "1" );
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob320 prob320 = new Prob320();
    System.out.println(prob320.generateAbbreviations("word"));
  }
}
