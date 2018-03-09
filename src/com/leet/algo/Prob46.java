package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by ayanc on 11/10/17.
 */
public class Prob46 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length < 1) return result;
    permute(result, nums, new ArrayList<>());
    return  result;
  }

  public void permute(List<List<Integer>> result, int[] nums, List<Integer> list) {
    if(nums.length == list.size()) {
      result.add(new ArrayList<>(list));
    }
    for (int i = 0; i < nums.length; i++) {
      if (list.contains(nums[i])) continue;
      list.add(nums[i]);
      permute(result, nums, list);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args){
    Prob46 prob46 = new Prob46();
    System.out.println(prob46.permute(new int[]{1, 2, 3}));
  }
}
