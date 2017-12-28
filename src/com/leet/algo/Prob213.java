package com.leet.algo;

/**
 * Created by ayanc on 12/24/17.
 */
public class Prob213 {
  public int rob(int[] nums) {
    int n;
    if(nums == null ||(n = nums.length) == 0) return 0;
    if(n == 1) return nums[0];
    return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
  }

  private int rob(int[] nums, int start, int end) {
    if(start == end) return nums[start];
    int[] sum = new int[end - start + 1];
    sum[0] = nums[start];
    if(nums[start] > nums[start + 1]) sum[1] = nums[start];
    else sum[1] = nums[start + 1];
    for(int i = start + 2; i <= end; i++){
      if(nums[i] + sum[i - start - 2] > sum[i - start - 1]) sum[i - start] = nums[i] + sum[i - start - 2];
      else sum[i - start] = sum[i - start - 1];
    }
    return sum[end - start];
  }

  public static void main(String[] args){
    Prob213 prob213 = new Prob213();
    System.out.println(prob213.rob(new int[]{1,1,1,1}));
  }
}
