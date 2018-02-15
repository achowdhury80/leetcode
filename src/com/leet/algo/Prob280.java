package com.leet.algo;

/**
 * Created by ayanc on 2/15/18.
 */
public class Prob280 {
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length < 2) return;
    if (nums[0] > nums[1]) swap(nums, 0, 1);
    for (int i = 1; i < nums.length - 1; i++) {
      if (i % 2 == 1 && nums[i] < nums[i + 1] || i % 2 == 0 && nums[i] > nums[i + 1]) swap(nums, i, i + 1);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
