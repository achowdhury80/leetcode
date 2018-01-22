package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob80 {
  public int removeDuplicates(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    if(nums.length == 1) return 1;
    int cur = 2;
    int next = 2;

    while (next < nums.length){
      boolean change = nums[cur - 1] == nums[cur - 2];
      if(change && nums[next] == nums[cur -1]){
        next = findNextPos(nums, next, nums[cur - 1]);
        if(next == -1) return cur;
      }
      nums[cur] = nums[next];
      cur++;
      next++;
    }
    return cur;
  }

  private int findNextPos(int[] nums, int last, int lastVal){
    for(int i = last + 1; i < nums.length; i++){
      if(nums[i] != lastVal) return i;
    }
    return -1;
  }

  public static void main(String[] args){
    int[] nums;
    nums = new int[]{1,1,1,2,2,3};
    Prob80 prob80 = new Prob80();
    System.out.println(prob80.removeDuplicates(nums));
    Arrays.stream(nums).forEach(x -> System.out.print(x + ", "));
  }
}
