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
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < nums.length; i++){
      list.add(nums[i]);
    }
    result.add(new ArrayList<>());
    result.addAll(subsets(list));
    return result;
  }


  public List<List<Integer>> subsets(List<Integer> nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.size() == 0) return result;
    Integer i = nums.get(0);
    result.add(Arrays.asList(new Integer[]{i}));
    if(nums.size() > 1){
      List<Integer> sublist2 = new ArrayList<Integer>(nums.subList(1, nums.size()));
      List<List<Integer>> subset1 = subsets(sublist2);
      result.addAll(subset1);
      for(int j = 0; j < subset1.size();j++){
        List<Integer> list = new ArrayList<>(subset1.get(j));
        list.add(i);
        result.add(list);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob78 prob78 = new Prob78();
    System.out.println(prob78.subsets(new int[]{1,2,3}));
  }
}
