package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 11/10/17.
 */
public class Prob46 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length < 1) return result;
    return  permute(nums, 0);
  }

  public List<List<Integer>> permute(int[] nums, int startIndex) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums.length == startIndex + 1) {
      result.add(Arrays.asList(new Integer[]{nums[startIndex]}));
      return result;
    }
    Integer firstNumber = nums[startIndex];
    List<List<Integer>> partialResult = permute(nums, startIndex + 1);
    for(List<Integer> list : partialResult){
      for(int i = 0; i < list.size(); i++){
        result.add(addNCreateNewList(list, firstNumber, i));
      }
      List<Integer> newList = new ArrayList<>(list);
      newList.add(firstNumber);
      result.add(newList);
    }
    return result;
  }

  public List<Integer> addNCreateNewList(List<Integer> list, Integer number, int index){
    List<Integer> result = new ArrayList<>(list);
    result.add(index, number);
    return result;
  }

  public static void main(String[] args){
    Prob46 prob46 = new Prob46();
    System.out.println(prob46.permute(new int[]{1, 2, 3}));
  }
}
