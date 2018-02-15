package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob254 {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
    if (n < 4) return result;
    helper(result, new ArrayList<>(), 2, n);
    return result;
  }

  private void helper(List<List<Integer>> result, List<Integer> items, int start, int n) {
    int i = start;
    while (i * i <= n) {
      if (n % i == 0) {
        List<Integer> newList = new ArrayList<>(items);
        newList.add(i);
        List<Integer> newList1 = new ArrayList<>(newList);
        newList1.add(n / i);
        result.add(newList1);
        helper(result, newList, i, n / i);
      }
      i++;
    }
  }

  public static void main(String[] args) {
    Prob254 prob254 = new Prob254();
    System.out.println(prob254.getFactors(12));
  }
}
