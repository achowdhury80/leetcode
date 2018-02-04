package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob179 {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length < 1) return "";
    String[] num_strs = new String[nums.length];
    IntStream.range(0, nums.length).forEach(x -> num_strs[x] = "" + nums[x]);
    Arrays.sort(num_strs, (String x, String y) -> {
      String s1 = x + y;
      String s2 = y + x;
      return s2.compareTo(s1);
    });
    if (num_strs[0].charAt(0) == '0') return "0";
    StringBuilder sb = new StringBuilder();
    IntStream.range(0, num_strs.length).forEach(x -> sb.append(num_strs[x]));
    return sb.toString();
  }
//  public String largestNumber(int[] nums) {
//    ArrayList<Integer>[] numbers = new ArrayList[10];
//    for (int i = 0; i < 10; i++) {
//      numbers[i] = new ArrayList<>();
//    }
//    for (int i = 0; i < nums.length; i++) {
//      int firstNumber = ("" + nums[i]).charAt(0) - '0';
//      numbers[firstNumber].add(nums[i]);
//    }
//
//    String result = "";
//    for (int i = 9; i > - 1; i--) {
//      ArrayList<Integer> list = numbers[i];
//      if ( i != 0) Collections.sort(list, (x, y) -> compare(x, y));
//      for (Integer integer : list) {
//        result += integer;
//      }
//    }
//    return result.startsWith("0") ? "0" : result;
//  }

//  private int compare(int x, int y) {
//    int xLength = ("" + x).length();
//    int yLength = ("" + y).length();
//    if (xLength == yLength) return y - x;
//    if (xLength > yLength) return compareNumberWithDiffernetLength(yLength, x, y);
//    else return -compareNumberWithDiffernetLength(xLength, y, x);
//  }
//
//  private int compareNumberWithDiffernetLength(int smallerLength, int bigger, int smaller) {
//    int subX = new Integer(("" + bigger).substring(0, smallerLength));
//    if (subX > smaller) {
//      return -1;
//    } else if (subX < smaller) {
//      return 1;
//    } else {
//      return compare(Integer.valueOf(("" + bigger).substring(smallerLength)), smaller);
//    }
//  }

  public static void main(String[] args){
    Prob179 prob179 = new Prob179();
    System.out.println(prob179.largestNumber(new int[]{3, 30, 34, 5, 9}));
    System.out.println(prob179.largestNumber(new int[]{121, 12}));
    System.out.println(prob179.largestNumber(new int[]{128, 12}));
  }
}
