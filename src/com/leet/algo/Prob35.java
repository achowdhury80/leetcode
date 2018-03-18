package com.leet.algo;

/**
 * Created by ayanc on 3/16/18.
 */
public class Prob35 {
  //O(logn)
  public int searchInsert(int[] nums, int target) {
    if(nums == null || nums.length == 0) return -1;
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] > target) high = mid - 1;
      else  low = mid + 1;
    }
    return nums[low] >= target ? low : low + 1;
  }

  public static void main(String[] args) {
    Prob35 prob35 = new Prob35();
    System.out.println(prob35.searchInsert(new int[]{1, 3, 5, 6}, 2));
  }
}
