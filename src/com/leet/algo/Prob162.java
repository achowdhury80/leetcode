package com.leet.algo;

/**
 * Created by ayanc on 1/17/18.
 */
public class Prob162 {
  public int findPeakElement(int[] nums) {
    if(nums.length < 2 || nums[0] > nums[1]) return 0;
    if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
    for(int i = 1; i < nums.length - 1; i++){
      if(nums[i] > nums[i + 1]) return i;
    }
    return -1;
  }

  public static void main(String[] args){
    Prob162 prob162 = new Prob162();
    System.out.println(prob162.findPeakElement(new int[]{1, 2, 3, 1}));
  }
}
