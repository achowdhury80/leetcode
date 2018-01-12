package com.leet.algo;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob665 {
  public boolean checkPossibility(int[] nums) {
    if(nums == null || nums.length == 0) return false;
    if(nums.length < 3) return true;
    int[] sequences = new int[2];
    sequences[0] = 0;
    for(int i = 1; i < nums.length; i++){
      if(nums[i] < nums[i - 1]) {
        if (sequences[1] != 0) return false;
        else sequences[1] = i;
      }
    }
    if(sequences[1] == 0 || sequences[1] == 1 || sequences[1] == nums.length - 1) return true;
    if(nums[sequences[1] - 1] <= nums[sequences[1] + 1]) return true;
    if(nums[sequences[1] - 2] <= nums[sequences[1]]) return true;
    return false;
  }



  public static void main(String[] args){
    System.out.println(new Prob665().checkPossibility(new int[]{2,3,3,2,4}));
  }
}
