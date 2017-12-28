package com.leet.algo;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPos {

  public int searchInsert(int[] nums, int target) {
    if(nums == null || nums.length == 0) return -1;
    return findPosition(nums, 0, nums.length - 1, target);
  }

  private int findPosition(int[] nums, int lowerIndex, int upperIndex, int target){
    int mid = (lowerIndex + upperIndex) / 2;
    if(target == nums[mid]) return mid;
    if(target > nums[mid]){
      if(lowerIndex == upperIndex) return lowerIndex + 1;
      lowerIndex = mid + 1;
    }else{
      if(lowerIndex == upperIndex) return lowerIndex;
      upperIndex = mid - 1;
    }
    return findPosition(nums, lowerIndex, upperIndex, target);
  }

  public static void main(String[] args){
    System.out.println(new SearchInsertPos().searchInsert(new int[]{1, 3}, 0));
  }
}
