package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob526 {
  public int countArrangement(int N) {
    if(N < 2) return N;
    int[] nums = new int[N + 1];
    IntStream.range(0, nums.length).forEach(idx -> nums[idx] = idx);
    return countArrangement(nums, 1);
  }

  private int countArrangement(int[] nums, int start) {
    int result = 0;
    if(start == nums.length){
      return 1;
    }
    for(int i = start; i < nums.length; i++){
      swap(nums, start, i);
      if(nums[start] % start == 0 || start % nums[start] == 0) {
        result += countArrangement(nums, start + 1);
      }
      swap(nums, start, i);
    }
    return result;
  }

  private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args){
    Prob526 prob526 = new Prob526();
    System.out.println(prob526.countArrangement(1));
    System.out.println(prob526.countArrangement(2));
    System.out.println(prob526.countArrangement(3));
  }

}
