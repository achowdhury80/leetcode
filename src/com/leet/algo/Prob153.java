package com.leet.algo;

/**
 * Created by ayanc on 1/17/18.
 */
public class Prob153 {
  public int findMin(int[] nums) {
    if(nums.length == 1) return nums[0];
    int start = 0, end = nums.length - 1;
    Integer result = findMin(nums, start, end);
    if(result == null){
      if(nums[0] < nums[end]) return nums[0];
      return nums[end];
    }
    return result;
  }

  private int findMin(int[] nums, int start, int end){
    if(start == end) return nums[start];
    while(start < end){
      int mid = (start + end) / 2;
      if(mid == start)return Math.min(nums[mid], findMin(nums, mid + 1, end));
      else if(mid == end) return Math.min(findMin(nums, start, mid - 1), nums[mid]);
      else {
        if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) return nums[mid];
        return Math.min(findMin(nums, start, mid - 1), findMin(nums, mid + 1, end));
      }
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
