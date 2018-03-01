package com.leet.algo;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob41 {
  public int firstMissingPositive(int[] nums) {
    int n;
    if (nums == null || (n = nums.length) < 1) return 1;
    for (int i = 0; i < n ; i++)
      while (nums[i] > 0 && nums[i] < n + 1 && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
    for (int i = 0; i < n; i++) if (nums[i] != i + 1) return i + 1;
    return nums.length + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    Prob41 prob41 = new Prob41();
    System.out.println(prob41.firstMissingPositive(new int[]{1, 2, 0}));
    System.out.println(prob41.firstMissingPositive(new int[]{3, 4, -1, 1}));
  }
}
