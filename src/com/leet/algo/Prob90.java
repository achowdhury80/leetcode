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
    return subsetsWithDup(nums, 0, nums.length - 1);
  }

  public List<List<Integer>> subsetsWithDup(int[] nums, int start, int end){
    List<List<Integer>> result = new ArrayList<>();
    if(start > end){
      return result;
    }
    if(start == end) {
      List<Integer> list = new ArrayList<>();
      list.add(nums[start]);
      result.add(list);
      result.add(new ArrayList<>());
      return result;
    }
    if(nums[start] == nums[end]){
      List<Integer> list = new ArrayList<>();
      result.add(list);
      for(int i = 1; i <= end - start + 1; i++){
        list = new ArrayList<>(list);
        list.add(nums[start]);
        result.add(list);
      }
      return result;
    }
    if(nums[start] == nums[start + 1]){
      int last = lastPos(nums, start, nums[start]);
      if(last == nums.length - 1){
        result.addAll(subsetsWithDup(nums, start, last));
      } else {
        List<List<Integer>> left = subsetsWithDup(nums, start, last);
        List<List<Integer>> right = subsetsWithDup(nums, last + 1, end);
        for(List<Integer> list1 : left){
          for(List<Integer> list2 : right){
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            result.add(list);
          }
        }
      }
      return result;
    }
    List<List<Integer>> sub = subsetsWithDup(nums, start + 1, end);
    result.addAll(sub);
    for(List<Integer> list : sub){
      List<Integer> list1 = new ArrayList<>(list);
      list1.add(nums[start]);
      result.add(list1);
    }
    return result;
  }

  private int lastPos(int[] nums, int cur, int val){
    int result = cur + 1;
    while(result < nums.length && nums[result] == val){
      result++;
    }
    return --result;
  }

  public static void main(String[] args){
    Prob90 prob90 = new Prob90();
    System.out.println(prob90.subsetsWithDup(new int[]{1, 2, 2}));
  }
}
