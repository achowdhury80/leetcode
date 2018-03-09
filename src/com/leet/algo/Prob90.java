package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob90 {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || (n = nums.length) < 1) return result;
    Arrays.sort(nums);
    helper(result, nums, 0, new ArrayList<>());
    return result;
  }

  private void helper(List<List<Integer>> result, int[] nums, int start, List<Integer> list) {
    result.add(new ArrayList<>(list));
    if (start == nums.length) return;
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i - 1] == nums[i]) continue;
      list.add(nums[i]);
      helper(result, nums, i + 1, list);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args){
    Prob90 prob90 = new Prob90();
    System.out.println(prob90.subsetsWithDup(new int[]{1, 2, 2}));
  }
}
