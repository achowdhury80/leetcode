package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob33 {
  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1, new Integer[]{null});
  }

  public int search(int[] nums, int target, int start, int end, Integer[] pivotIndex) {
    if(start == end && nums[start] == target) return start;
    if(start > end) return -1;
    int mid = (start + end) / 2;
    if(nums[mid] == target) return mid;
    if(pivotIndex[0] == null){
      if(mid > 0 && nums[mid] < nums[mid - 1]) pivotIndex[0] = mid;
    }
    if(pivotIndex[0] == null){
      int leftIndex = search(nums, target, start, mid - 1, pivotIndex);
      if(leftIndex != -1) return leftIndex;
      return search(nums, target, mid + 1, end, pivotIndex);
    } else {
      if(start > pivotIndex[0] || end < pivotIndex[0]){
        if(nums[mid] > target) return search(nums, target, start, mid - 1, pivotIndex);
        else return search(nums, target, mid + 1, end, pivotIndex);
      } else {
        if(pivotIndex[0] >= mid){
          if(nums[mid] > target){
            return -1;
          } else {
            int leftIndex = search(nums, target, start, mid - 1, pivotIndex);
            if(leftIndex != -1) return leftIndex;
            return search(nums, target, mid + 1, end, pivotIndex);
          }
        } else {
          if(nums[mid] > target){
            int leftIndex = search(nums, target, start, pivotIndex[0] - 1, pivotIndex);
            if(leftIndex != -1) return leftIndex;
            return search(nums, target, pivotIndex[0], end, pivotIndex);
          } else {
            return search(nums, target, mid + 1, end, pivotIndex);
          }
        }
      }
    }
  }

  public static void main(String[] args){
    Prob33 prob33 = new Prob33();
    System.out.println(prob33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 9));
    System.out.println(prob33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
    System.out.println(prob33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    System.out.println(prob33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
    System.out.println(prob33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
  }
}
