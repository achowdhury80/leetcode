package com.leet.algo;

/**
 * Created by ayanc on 12/24/17.
 */
public class Prob376 {
  public int wiggleMaxLength(int[] nums) {
    int n;
    if(nums == null || (n = nums.length) == 0) return 0;
    if(n < 2) return 1;
    int up = 1;
    int down = 1;
    for(int i = 1; i < nums.length; i++){
      if(nums[i] > nums[i - 1]){
        up = down + 1;
      } else if(nums[i] < nums[i - 1]){
        down = up + 1;
      }
    }
    return Math.max(up, down);
  }
}
