package com.leet.algo;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob674 {
  public int findLengthOfLCIS(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    if(nums.length == 1) return 1;
    return findLengthOfLCIS(nums, 0, nums.length - 1);
  }

  private int findLengthOfLCIS(int[] nums, int start, int end) {
    if(start == end) return 1;

    int mid = (start + end) / 2;
    int leftCount = findLengthOfLCIS(nums, start, mid);
    int rightCount = findLengthOfLCIS(nums, mid + 1, end);
    if(nums[mid] >= nums[mid + 1]) {
      if(leftCount < rightCount) return rightCount;
      return leftCount;
    }
    int countLeft = 1;
    for(int i = mid - 1; i >= start; i--){
      if(nums[i] < nums[i + 1]) countLeft++;
      else break;
    }
    int countRight = 1;
    for(int i = mid + 2; i <= end; i++){
      if(nums[i] > nums[i - 1]) countRight++;
      else break;
    }
    int count = countLeft + countRight;
    if(leftCount > rightCount){
      if(leftCount > count) return leftCount;
      else return count;
    } else {
      if(rightCount > count) return rightCount;
      else return count;
    }


  }

  public static void main(String[] args){
    System.out.println(new Prob674().findLengthOfLCIS(new int[]{1,3,5,4,7}));
  }
}
