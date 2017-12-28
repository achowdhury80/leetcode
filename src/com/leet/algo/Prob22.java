package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 11/10/17.
 */
public class Prob22 {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if(n == 0) return result;
    if(n == 1) {
      result.add("()");
      return result;
    }
    List<String> subResult = generateParenthesis(n - 1);
    Set<String> set = new HashSet<>();
    for(String st : subResult){

    }
    return new ArrayList<>(set);
  }
}
