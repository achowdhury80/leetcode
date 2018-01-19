package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob209 {
  public int minSubArrayLen(int s, int[] nums) {
    if(nums == null || nums.length < 1) return 0;
    if(nums.length == 1 && nums[0] >= s) return 1;
    int i = 0, j = 0;
    long sum = 0;
    int result = Integer.MAX_VALUE;
    while(j < nums.length && result > 1){
      sum += nums[j++];
      while(sum >= s && result > 1){
        result = Math.min(result, j - i);
        sum -= nums[i++];
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

  public static void main(String[] args){
    Prob209 prob209 = new Prob209();
    System.out.println(prob209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
  }
}
