package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob189 {
  public void rotate(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k == 0) return;
    k %= nums.length;
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int temp = nums[i];
      nums[i++] = nums[j];
      nums[j--] = temp;
    }
  }
}
