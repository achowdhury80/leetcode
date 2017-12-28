package com.leet.algo;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob665 {
  public boolean checkPossibility(int[] nums) {
    if(nums == null || nums.length == 0) return false;
    if(nums.length < 2) return true;
    Integer minValue = null;
    int modified = 0;
    if(nums[0] > nums[1]) {
      minValue = nums[1];
      modified++;
    }
    else minValue = nums[0];
    for(int i = 2; i < nums.length; i++){
      if(nums[i] >= nums[i - 1]){
        minValue = nums[i - 1];
      } else {
        if (modified > 0) return false;
        if (nums[i] < minValue && minValue < nums[i - 1]) return false;
        modified++;
      }
    }
    if(modified < 2) return true;
    return false;
  }



  public static void main(String[] args){
    System.out.println(new Prob665().checkPossibility(new int[]{2,3,3,2,4}));
  }
}
