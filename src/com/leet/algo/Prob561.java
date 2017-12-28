package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 8/25/17.
 */
public class Prob561 {
  public static void main(String[] args){
    Prob561 prob561 = new Prob561();
    System.out.println(prob561.arrayPairSum(new int[]{1,4,3,2}));
  }
  public int arrayPairSum(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    Arrays.sort(nums);
    int sum = 0;
    for(int i = 0; i < nums.length; i += 2) sum += nums[i];
    return sum;
  }
}
