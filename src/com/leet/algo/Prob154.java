package com.leet.algo;

/**
 * Created by ayanc on 2/22/18.
 */
public class Prob154 {
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    int mid = -1;
    while (low < high) {
      mid = low + (high - low) / 2;
      if (nums[mid] > nums[high]) {
        low = mid + 1;
      } else if (nums[mid] < nums[high]) {
        high = mid;
      } else {
        high--;
      }
    }
    return nums[low];
  }
}
