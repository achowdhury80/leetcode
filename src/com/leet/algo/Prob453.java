package com.leet.algo;

/**
 * Created by ayanc on 10/23/17.
 */
public class Prob453 {
  public int minMoves(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      min = Math.min(min, nums[i]);
    }
    return sum - nums.length * min;
  }

  public static void main(String[] args){
    Prob453 prob453 = new Prob453();
    System.out.println(prob453.minMoves(new int[]{1,3,6, 7}));
  }
}
