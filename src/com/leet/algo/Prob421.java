package com.leet.algo;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob421 {
  public int findMaximumXOR(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    int max = Integer.MIN_VALUE;
    int min  = Integer.MAX_VALUE;
    for(int i = 0; i < nums.length; i++){
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }
    return max ^ min;
  }
  public static void main(String[] args){
    Prob421 prob421 = new Prob421();
    System.out.println(prob421.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
  }


}
