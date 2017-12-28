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
    if(n <= 0) return result;
    backtrack(result, "", 0, 0, n);
    return result;
  }

  private void backtrack(List<String> list, String str, int opened, int closed, int max){
    if(str.length() == 2 * max){
      list.add(str);
      return;
    }
    if(opened < max) backtrack(list, str + "(", opened + 1, closed, max);
    if(closed < opened) backtrack(list, str + ")", opened, closed + 1, max);
  }

  public static void main(String[] args){
    Prob22 prob22 = new Prob22();
    System.out.println(prob22.generateParenthesis(3));
  }
}
