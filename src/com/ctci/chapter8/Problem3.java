package com.ctci.chapter8;

/**
 * Created by ayanc on 7/23/17.
 */
public class Problem3 {
  public int findMagicIndex(int[] nums){
    if(nums == null || nums.length < 1) return -1;
    return findMagicIndexDistinct(nums, 0, nums.length - 1);
    //return findMagicIndexDuplicate(nums, 0, nums.length - 1);

  }

  /**
   * with sorted distinct integers
   * @param nums
   * @param lower
   * @param upper
   * @return
   */
  private int findMagicIndexDistinct(int[] nums, int lower, int upper){
    if(lower > upper) return -1;
    int mid = (lower + upper) / 2;
    if(nums[mid] == mid) return mid;
    if(nums[mid] < mid) return findMagicIndexDistinct(nums, mid + 1, upper);
    return findMagicIndexDistinct(nums, lower, mid - 1);
  }

  /**
   * with sorted duplicate integers
   * @param nums
   * @param lower
   * @param upper
   * @return
   */
  private int findMagicIndexDuplicate(int[] nums, int lower, int upper){
    if(lower > upper) return -1;
    int mid = (lower + upper) / 2;
    if(nums[mid] == mid) return mid;
    if(nums[mid] < mid){
      int lowerMagicIndex = -1;
      if(nums[mid] >= lower){
        lowerMagicIndex = findMagicIndexDuplicate(nums, lower, nums[mid]);
      }
      if(lowerMagicIndex > -1) return lowerMagicIndex;
      return findMagicIndexDuplicate(nums, mid + 1, upper);
    }
    int upperMagicIndex = -1;
    if(nums[mid] <= upper){
      upperMagicIndex = findMagicIndexDuplicate(nums, nums[mid], upper);
    }
    if(upperMagicIndex > -1) return upperMagicIndex;
    return findMagicIndexDuplicate(nums, lower, mid - 1);
  }
}
