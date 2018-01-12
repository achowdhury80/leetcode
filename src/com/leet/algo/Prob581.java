package com.leet.algo;

/**
 * Created by ayanc on 8/25/17.
 */
public class Prob581 {
  public static void main(String[] args){
    Prob581 prob581 = new Prob581();
    System.out.println(prob581.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
  }
  public int findUnsortedSubarray(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    int lastDown = -1;
    int smallest = Integer.MAX_VALUE;
    int smallestIdx = -1;
    int maxUp = Integer.MIN_VALUE;
    for(int i = 1; i < nums.length; i++){
      if(nums[i] < nums[i - 1]){
        lastDown = i;
        if(nums[i] < smallest){
          smallest = nums[i];
          smallestIdx = i;
        }
        maxUp = Math.max(maxUp, nums[i - 1]);
      }
    }

    if(lastDown == -1 || smallestIdx == -1) return 0;
    int left = -1;
    for(int i = smallestIdx - 1; i > -1; i--){
      if(nums[i] > nums[smallestIdx]){
        left = i;
      }
    }
    int right = lastDown;
    for(int i = nums.length - 1; i > lastDown; i--){
      if(nums[i] < maxUp || nums[i] < nums[i - 1]) {
        right = i;
        break;
      }

    }

    return right - left + 1;
  }
}
