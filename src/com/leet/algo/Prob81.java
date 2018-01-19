package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob81 {
  public boolean search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1, new Integer[]{null});
  }

  public boolean search(int[] nums, int target, int start, int end, Integer[] pivotIndex) {
    if(start == end && nums[start] == target) return true;
    if(start == end) return false;
    if(start > end) return false;
    int mid = (start + end) / 2;
    if(nums[mid] == target) return true;
    if(pivotIndex[0] == null){
      if(mid > 0 && nums[mid] < nums[mid - 1]) pivotIndex[0] = mid;
    }
    if(pivotIndex[0] == null){
      boolean inLeft = search(nums, target, start, mid - 1, pivotIndex);
      if(inLeft) return true;
      return search(nums, target, mid + 1, end, pivotIndex);
    } else {
      if(start > pivotIndex[0] || end < pivotIndex[0]){
        if(nums[mid] > target) return search(nums, target, start, mid - 1, pivotIndex);
        else return search(nums, target, mid + 1, end, pivotIndex);
      } else {
        if(pivotIndex[0] >= mid){
          if(nums[mid] > target){
            return false;
          } else {
            boolean inLeft = search(nums, target, start, mid - 1, pivotIndex);
            if(inLeft) return true;
            return search(nums, target, mid + 1, end, pivotIndex);
          }
        } else {
          if(nums[mid] > target){
            boolean inLeft = search(nums, target, start, pivotIndex[0] - 1, pivotIndex);
            if(inLeft) return true;
            return search(nums, target, pivotIndex[0], end, pivotIndex);
          } else {
            return search(nums, target, mid + 1, end, pivotIndex);
          }
        }
      }
    }
  }

  public static void main(String[] args){
    Prob81 prob81 = new Prob81();
    System.out.println(prob81.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 9));
    System.out.println(prob81.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
    System.out.println(prob81.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    System.out.println(prob81.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
    System.out.println(prob81.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
  }
}
