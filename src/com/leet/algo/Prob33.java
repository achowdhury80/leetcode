package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob33 {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length < 1) return -1;
    int lo = 0, hi = nums.length - 1, mid = -1;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] >= nums[lo]) {
        if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
        else lo = mid + 1;
      } else {
        if (target <= nums[hi] && target > nums[mid]) lo = mid + 1;
        else hi = mid - 1;
      }
    }
    return -1;
  }

  private int search(int[] nums, int target, int start, int end) {
    if (end < start) return -1;
    if (start == end) {
      if (nums[start] == target) return start;
      return -1;
    }
    int mid = start + (end - start) / 2 ;
    if (nums[mid] == target) return mid;
    int res = -1;
    if (nums[mid] > target) {
      res = search(nums, target, start, mid - 1);
      if (res == -1 && nums[mid] > nums[end]) return search(nums, target, mid + 1, end);
      return res;
    } else {
      res = search(nums, target, mid + 1, end);
      if (res == -1 && nums[mid] < nums[start]) return search(nums, target, start, mid - 1);
      return res;
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
