package com.leet.algo;

/**
 * Created by ayanc on 3/10/18.
 */
public class Prob283 {
  public void moveZeroes(int[] nums) {
    if (nums == null) return;
    int pos = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[++pos] = nums[i];
        if (i != pos) nums[i] = 0;
      }
    }
  }
}
