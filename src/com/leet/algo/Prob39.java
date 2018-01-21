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
    return combinationSum(candidates, 0, target);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int start, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if(start + 1 == candidates.length){
      if(target >= candidates[start] && target % candidates[start] == 0){
        List<Integer> list = new ArrayList<>();
        while (target != 0){
          list.add(candidates[start]);
          target -= candidates[start];
        }
        result.add(list);
        return result;
      } else return result;
    }
    for(int i = start; i < candidates.length; i++){
      if(candidates[i] <= target){
        List<Integer> list = new ArrayList<>();
        list.add(candidates[i]);
        if(target > candidates[i]){
          List<List<Integer>> sub = combinationSum(candidates, i, target - candidates[i]);
          if(!sub.isEmpty()) {
            for(List<Integer> list1 : sub){
              list1.add(candidates[i]);
            }
            result.addAll(sub);
          }
        } else {
          result.add(list);
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob39 prob39 = new Prob39();
    System.out.println(prob39.combinationSum(new int[]{2, 3, 6, 7}, 7));
  }
}
