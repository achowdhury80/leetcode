package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob303 {
  private int[] nums = null;
  private int[] sum = null;

  public Prob303(int[] nums) {
    this.nums = nums;
    if(nums != null && nums.length != 0){
      sum = new int[nums.length];
      sum[0] = nums[0];
      for(int i = 1; i < nums.length; i++){
        sum[i] = sum[i - 1] + nums[i];
      }
    }
  }

  public int sumRange(int i, int j) {
    return i > 0 ? (sum[j] - sum[i - 1]) : sum[j];
  }
}
