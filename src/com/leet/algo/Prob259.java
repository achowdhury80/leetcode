package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob259 {
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    int count = 0;
    for (int i = 0; i < len - 2; i++) {
      int left = i + 1, right = len - 1;
      while (left < right) {
        if (nums[i] + nums[left] + nums[right] < target) {
          count += right - left;
          left++;
        } else right--;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Prob259 prob259 = new Prob259();
    System.out.println(prob259.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    System.out.println(prob259.threeSumSmaller(new int[]{3, 1, 0, -2}, 4));
  }
}
