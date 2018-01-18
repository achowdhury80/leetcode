package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob34 {
  public int[] searchRange(int[] nums, int target) {
    if(nums == null || nums.length < 0) return new int[]{-1, -1};
    return searchRange(nums, target, 0, nums.length - 1);
  }

  public int[] searchRange(int[] nums, int target, int start, int end) {
    if(start > end) return new int[]{-1, -1};
    if(start == end && nums[start] == target) return new int[]{start, start};
    if(start == end) return new int[]{-1, -1};
    if(nums[start] == target && nums[end] == target) return new int[]{start, end};
    int mid = (start + end) / 2;
    if(nums[mid] == target){
      int[] right = searchRange(nums, target, mid + 1, end);
      int[] left = searchRange(nums, target, start, mid - 1);
      if(right[0] == -1 && left[0] == -1) return new int[]{mid, mid};
      if(left[0] == - 1) return new int[]{mid, right[1]};
      if(right[0] == - 1) return new int[]{left[0], mid};
      return new int[]{left[0], right[1]};
    } else if(nums[mid] < target){
      return searchRange(nums, target, mid + 1, end);
    } else {
      return searchRange(nums, target, start, mid - 1);
    }
  }

  public static void main(String[] arhs){
    Prob34 prob34 = new Prob34();
    int[] result = prob34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    System.out.println(result[0] + "," + result[1]);
    result = prob34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    System.out.println(result[0] + "," + result[1]);
  }
}
