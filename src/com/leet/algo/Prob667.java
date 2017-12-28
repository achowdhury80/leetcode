package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob667 {
  private int[] result = null;
  public int[] constructArray(int n, int k) {
    if(n < 2 || k < 1) return null;
    int[] nums = new int[n + 1];
    IntStream.range(0, nums.length).forEach(idx -> nums[idx] = idx);
    constructArray(nums, 1, k);
    return result;
  }

  private void constructArray(int[] nums, int start, int k){
    if(result != null) return ;
    if(start == nums.length){
      Set<Integer> set = new HashSet<>();
      IntStream.range(1, nums.length).forEach(idx ->{
        set.add(Math.abs(nums[idx] - nums[idx - 1]));
      });
      if(set.size() == k) {
        result = new int[nums.length - 1];
        IntStream.range(1, nums.length).forEach(idx -> result[idx - 1] = nums[idx]);
        return;
      }
    }
    for(int i = start; i < nums.length && result == null; i++){
      swap(nums, start, i);
      constructArray(nums, start + 1, k);
      swap(nums, i, start);
    }


  }

  private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    Prob667 prob667 = new Prob667();
    Arrays.stream(prob667.constructArray(3, 1)).forEach(x -> System.out.print(x + ", "));
    System.out.println();
    Arrays.stream(prob667.constructArray(3, 2)).forEach(x -> System.out.print(x + ", "));
  }
}
