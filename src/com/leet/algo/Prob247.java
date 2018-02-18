package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob247 {

  public List<String> findStrobogrammatic(int n) {
    return helper(n, n);
  }

  private List<String> helper(int n, int m) {
    if (n < 1) return Arrays.asList("");
    if (n == 1) return Arrays.asList("0", "1", "8");
    List<String> sub = helper(n - 2, m);
    List<String> result = new ArrayList<>();
    for (String s : sub) {
      if (n != m) result.add("0" + s + "0");
      result.add("1" + s + "1");
      result.add("6" + s + "9");
      result.add("8" + s + "8");
      result.add("9" + s + "6");
    }
    return result;
  }

//  private static final String[] NUMS = new String[] {"0", "1", "6", "8", "9"};
//  public List<String> findStrobogrammatic(int n) {
//    List<String> result = new ArrayList<>();
//    if ( n < 1) return result;
//    if (n == 1) {
//      result.addAll(Arrays.asList("0", "1", "8"));
//      return result;
//    }
//    helper(n, result);
//    return result;
//  }
//
//  private void helper(int n, List<String> result) {
//    List<String> middleList = new ArrayList<>();
//    if (n % 2 == 0) middleList.add("");
//    else middleList.addAll(Arrays.asList("0", "1", "8"));
//    int part = n / 2;
//    List<String[]> pairs = new ArrayList<>();
//    findPairs(part, new StringBuilder(), new StringBuilder(), pairs);
//    for (String[] pair : pairs) {
//      for (String middle : middleList) {
//        result.add(pair[0] + middle + pair[1]);
//      }
//    }
//  }
//
//  private void findPairs(int n, StringBuilder sb1, StringBuilder sb2, List<String[]> list) {
//    if (n == 0) {
//      if (sb1.charAt(0) != '0') list.add(new String[]{sb1.toString(), sb2.toString()});
//      return;
//    }
//    for (int i = 0; i < NUMS.length; i++) {
//      findPairs(n - 1, sb1.append(NUMS[i]),
//          sb2.insert(0, NUMS[i].equals("6")? "9" : (NUMS[i].equals("9") ? "6" : NUMS[i])), list);
//      sb2.deleteCharAt(0);
//      sb1.deleteCharAt(sb1.length() - 1);
//    }
//  }

  public static void main(String[] args) {
    Prob247 prob247 = new Prob247();
    System.out.println(prob247.findStrobogrammatic(2));
  }
}
