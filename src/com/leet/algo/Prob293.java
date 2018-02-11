package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob293 {
  public List<String> generatePossibleNextMoves(String s) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < s.length() - 1; i++) if (s.charAt(i) == '+' && s.charAt(i + 1) == '+')
      result.add((i > 0 ? s.substring(0, i) : "") + "--" + (i + 2 < s.length() ? s.substring(i + 2) : ""));
    return result;
  }

  public static void main(String[] args) {
    Prob293 prob293 = new Prob293();
    System.out.println(prob293.generatePossibleNextMoves("++++"));
  }
}
