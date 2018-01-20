package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob216 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    if(k > 9 || k < 1) return result;
    List<Integer> nums = new ArrayList<>();
    IntStream.range(1, 10).forEach(x -> nums.add(x));
    return combinationSum3(k, n, nums, 0);
  }

  private List<List<Integer>> combinationSum3(int k, int n, List<Integer> nums, int start){
    List<List<Integer>> result = new ArrayList<>();
    if(k == 1){
      if(!nums.subList(start, nums.size()).contains(n)) return result;
      List<Integer> list = new ArrayList<>();
      list.add(n);
      result.add(list);
      return result;
    }
    for(int i = start; i < nums.size(); i++){
      int a = nums.get(i);
      if(a >= n) continue;
      List<List<Integer>> subResult = combinationSum3(k - 1, n - a, nums, i + 1);
      if(!subResult.isEmpty()){
        subResult.forEach(x -> x.add(a));
      }
      result.addAll(subResult);
    }
    return result;
  }

  public static void main(String[] args){
    Prob216 prob216 = new Prob216();
    System.out.println(prob216.combinationSum3(3, 7));
    System.out.println(prob216.combinationSum3(3, 9));
  }
}
