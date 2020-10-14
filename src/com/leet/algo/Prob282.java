package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/19/18.
 */
public class Prob282 {
  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    if (num == null || num.length() < 1) return result;
    helper(num, 0, 0, 0, result, "", target);
    return result;
  }

  public void helper(String num, int pos, long eval, long mult, 
		  List<String> result, String path, int target) {
    if (pos == num.length()) {
      if (target == eval) result.add(path);
      return;
    }
    for (int i = pos; i < num.length(); i++) {
      if (i != pos && num.charAt(pos) == '0') break;
      long cur = Long.parseLong(num.substring(pos, i + 1));
      if (pos == 0) helper(num, i + 1, cur, cur, result, path + cur, target);
      else {
        helper(num, i + 1, eval + cur, cur, result, path + "+" + cur, target);
        helper(num, i + 1, eval - cur, -cur, result, path + "-" + cur, target);
        helper(num, i + 1, eval - mult + mult * cur, mult * cur, result, path 
        		+ "*" + cur, target);
      }
    }
  }

  public static void main(String[] args) {
    Prob282 prob282 = new Prob282();
    System.out.println(prob282.addOperators("123", 6));
    System.out.println(prob282.addOperators("105", 5));
  }
}
