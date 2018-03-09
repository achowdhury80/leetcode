package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if(candidates == null || candidates.length < 1) return result;
    combinationSum(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  public void combinationSum(List<List<Integer>> result, int[] candidates, int remaining, List<Integer> list, int start) {
    if (remaining < 0) return;
    if (remaining == 0) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      list.add(candidates[i]);
      combinationSum(result, candidates, remaining - candidates[i], list, i);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args){
    Prob39 prob39 = new Prob39();
    System.out.println(prob39.combinationSum(new int[]{2, 3, 6, 7}, 7));
  }
}
