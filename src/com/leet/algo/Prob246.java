package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob246 {
  public boolean isStrobogrammatic(String num) {
    if (num == null || num.length() < 1) return false;
    List<Character> list = Arrays.asList(new Character[]{'0', '1', '6', '8', '9'});
    for (int i = 0; i < (num.length() + 1) / 2; i++) {
      int right = num.length() - 1 - i;
      char leftChar = num.charAt(i);
      char rightChar = num.charAt(right);
      if (!list.contains(leftChar) || !list.contains(rightChar)) return false;
      if (leftChar != rightChar) {
        if (leftChar == '6' && rightChar == '9' || leftChar == '9' && rightChar == '6') continue;
        return false;
      } else if (leftChar == '6' || leftChar == '9') return false;
    }
    return true;
  }

  public static void main(String[] args){
    Prob246 prob246 = new Prob246();
    System.out.println(prob246.isStrobogrammatic("69"));
    System.out.println(prob246.isStrobogrammatic("88"));
    System.out.println(prob246.isStrobogrammatic("818"));
  }
}
