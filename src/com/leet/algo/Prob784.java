package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob784 {
  public List<String> letterCasePermutation(String S) {
    List<String> result = new ArrayList<>();
    if (S == null) return result;
    if (S.equals("")){
      result.add(S);
      return result;
    }
    helper(S, 0, result, "");
    return result;
  }

  private void helper(String S, int start, List<String> list, String st) {
    if (st.length() == S.length()) {
      list.add(st);
      return;
    }
    for (int i = start; i < S.length(); i++) {
      char c = S.charAt(i);
      helper(S, i + 1, list, st + c);
      if (Character.isLetter(c)) helper(S, i + 1, list, st + (c >= 'a' && c <= 'z' ? Character.toUpperCase(c) : Character.toLowerCase(c)));
    }
  }
}
