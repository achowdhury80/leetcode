package com.leet.algo;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob665 {
  public boolean checkPossibility(int[] nums) {
    int count = 0;
    for (int i = 1; i < nums.length && count < 2; i++) {
      if (nums[i - 1] > nums[i]) {
        count++;
        if (i < 2 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i];
        else nums[i] = nums[i - 1];
      }
    }
    return count < 2;
  }



  public static void main(String[] args){
    System.out.println(new Prob665().checkPossibility(new int[]{2,3,3,2,4}));
  }
}
