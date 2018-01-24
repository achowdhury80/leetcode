package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length < 1) return result;
    Arrays.sort(nums);
    List<Integer> list = new ArrayList<>();
    list.add(nums[0]);
    result.add(list);
    if(nums.length < 2) return result;
    for(int i = 1; i < nums.length; i++){
      result = permuteUnique(result, nums[i]);
    }
    return result;
  }

  public List<List<Integer>> permuteUnique(List<List<Integer>> lists, int num) {
    List<List<Integer>> result = new ArrayList<>();
    for(List<Integer> list : lists){
      List<Integer> newList = new ArrayList<>(list);
      newList.add(0, num);
      result.add(newList);
      for(int i = 1; i < list.size(); i++){
        if(list.get(i - 1) == num) continue;
        else {
          newList = new ArrayList<>(list);
          newList.add(i, num);
          result.add(newList);
        }
      }
      if(num != list.get(list.size() - 1)){
        newList = new ArrayList<>(list);
        newList.add(num);
        result.add(newList);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob47 prob47 = new Prob47();
    //System.out.println(prob47.permuteUnique(new int[]{1,1,2}));
    System.out.println(prob47.permuteUnique(new int[]{2,2,1,1}));
  }
}
