package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if(candidates == null || candidates.length < 1) return result;
    return combinationSum2(candidates, target, 0);
  }

  private List<List<Integer>> combinationSum2(int[] candidates, int target, int start){
    List<List<Integer>> result = new ArrayList<>();
    if(start == candidates.length) return result;
    if(start == candidates.length - 1){
      if(candidates[start] == target){
        List<Integer> list = new ArrayList<>();
        list.add(candidates[start]);
        result.add(list);
      }
      return result;
    }
    if(candidates[start] <= target){
      if(candidates[start] == target){
        List<Integer> list = new ArrayList<>();
        list.add(candidates[start]);
        result.add(list);
      } else {
        List<List<Integer>> sub = combinationSum2(candidates, target - candidates[start], start + 1);
        if(!sub.isEmpty()){
          for(List<Integer> list : sub){
            list.add(candidates[start]);
          }
          result.addAll(sub);
        }
      }
    }
    List<Integer> newCandidates = new ArrayList<>();
    for(int i = start + 1; i < candidates.length; i++){
      if(candidates[i] != candidates[start]){
        newCandidates.add(candidates[i]);
      }
    }
    if(newCandidates.size() > 0){
      int[] newCandidateArr = new int[newCandidates.size()];
      IntStream.range(0, newCandidateArr.length).forEach(i -> newCandidateArr[i] = newCandidates.get(i));
      List<List<Integer>> sub = combinationSum2(newCandidateArr, target, 0);
      if(!sub.isEmpty()){
        result.addAll(sub);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob40 prob40 = new Prob40();
    System.out.println(prob40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }
}
