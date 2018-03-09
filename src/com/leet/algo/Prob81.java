package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob81 {
  public boolean search(int[] nums, int target) {
    int l = 0, h = nums.length - 1;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (nums[mid] == target) return true;
      if (nums[mid] > nums[h]) {
          if (nums[mid] > target && target >= nums[l] ) h = mid - 1;
          else l = mid + 1;
      } else if (nums[mid] < nums[h]) {
          if (target > nums[mid] && target <= nums[h]) l = mid + 1;
          else h = mid - 1;
      } else {
        h--;
      }
    }
    return false;
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
