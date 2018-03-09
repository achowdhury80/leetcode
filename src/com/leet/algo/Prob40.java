package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if(candidates == null || candidates.length < 1) return result;
    Arrays.sort(candidates);
    combinationSum2(result, candidates, target, 0, new ArrayList<>());
    return result;
  }

  private void combinationSum2(List<List<Integer>> result, int[] candidates, int target, int start, List<Integer> list){
    if(target < 0) return;
    if (target == 0) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i - 1] == candidates[i]) continue;
      list.add(candidates[i]);
      combinationSum2(result, candidates, target - candidates[i], i + 1, list);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args){
    Prob40 prob40 = new Prob40();
    System.out.println(prob40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }
}
