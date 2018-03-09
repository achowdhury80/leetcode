package com.leet.algo;

/**
 * Created by ayanc on 1/17/18.
 */
public class Prob153 {
  public int findMin(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      if (start == end) return nums[start];
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[end]) start = mid + 1;
      else if (nums[mid] < nums[start]) end = mid;
      else return nums[start];
    }
    return -1;
  }

  public static void main(String[] args){
    Prob153 prob153 = new Prob153();
    System.out.println(prob153.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    System.out.println(prob153.findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
    System.out.println(prob153.findMin(new int[]{1, 2, 4, 5, 6, 7, 0}));
    System.out.println(prob153.findMin(new int[]{5, 1, 2, 3, 4}));
  }
}
