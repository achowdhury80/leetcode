package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob163 {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    long start = lower;
    int i = 0;
    List<String> list = new ArrayList<>();
    while (i < nums.length) {
      int num = nums[i];
      if (start == num) start++;
      else if (start + 1 == num) {
        list.add("" + start);
        start = num + 1l;
      } else if (start < num){
        list.add("" + start + "->" + (num - 1));
        start = num + 1l;
      }
      i++;
    }
    if (start == upper) list.add("" + start);
    else if (start < upper) list.add(start + "->" + upper);
    return list;
  }

  public static void main(String[] args) {
    Prob163 prob163 = new Prob163();
    System.out.println(prob163.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    System.out.println(prob163.findMissingRanges(new int[]{1, 1, 1}, 1, 1));
    System.out.println(prob163.findMissingRanges(new int[]{2147483647}, 0, 2147483647));
  }
}
