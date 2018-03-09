package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob77 {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if(k > n || n < 1 || k < 1) return result;
    List<Integer> list = new ArrayList<>();
    IntStream.range(1,n + 1).forEach(x -> list.add(x));
    helper(result, list, k, 0, new ArrayList<>());
    return result;
  }

  private void helper(List<List<Integer>> result, List<Integer> nums, int k, int start, List<Integer> temp){
    if (temp.size() == k) {
      result.add(new ArrayList<>(temp));
      return;
    }
    if (start == nums.size()) return;
    for (int i = start; i < nums.size(); i++) {
      temp.add(nums.get(i));
      helper(result, nums, k, i + 1, temp);
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args){
    Prob77 prob77 = new Prob77();
    System.out.println(prob77.combine(4, 2));
  }
}
