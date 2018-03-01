package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/28/18.
 *
 * Get Target Number Using Number List and Arithmetic Operations

 Given a list of numbers and a target number, write a program to determine whether the target number can be calculated by applying "+-* or /" operations to the number list? You can assume () is automatically added when necessary.

    For example, given {1,2,3,4} and 21, return true. Because (1+2)*(3+4)=21
 *
 *
 */
public class TargetNumberUsingArithmetic {
  public boolean isReachable(List<Integer> list, int target) {
    if (list == null || list.size() < 1) return false;
    List<Integer> results = getResults(list, 0, list.size() - 1);
    for (int result : results) if (result == target) return true;
    return false;
  }

  private List<Integer> getResults(List<Integer> list, int left, int right) {
    List<Integer> result = new ArrayList<>();
    if (left > right) return result;
    if (left == right) {
      result.add(list.get(left));
      return result;
    }
    for (int i = left; i < right; i++) {
      List<Integer> result1 = getResults(list, left, i);
      List<Integer> result2 = getResults(list, i + 1, right);
      for (int x : result1) for (int y : result2) {
        result.add(x + y);
        result.add(x - y);
        result.add(x * y);
        if (y != 0) result.add(x /y);
      }
    }
    return result;
  }

  public static void main(String[] args)
}
