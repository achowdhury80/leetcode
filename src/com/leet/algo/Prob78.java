package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 11/3/17.
 */
public class Prob78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length == 0) return result;
    subsets(result, new ArrayList<Integer>(), nums, 0);
    return result;
  }


  public List<List<Integer>> subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
    result.add(new ArrayList<Integer>(list));
    for (int i = start; i < nums.length; i++) {
      list.add(nums[i]);
      subsets(result, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
    return result;
  }

  public static void main(String[] args){
    Prob78 prob78 = new Prob78();
    System.out.println(prob78.subsets(new int[]{1,2,3}));
  }
}
