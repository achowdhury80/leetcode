package com.leet.algo;

/**
 * Created by ayanc on 8/25/17.
 */
public class Prob581 {
  public static void main(String[] args){
    Prob581 prob581 = new Prob581();
    System.out.println(prob581.findUnsortedSubarray(new int[]{6, 4, 8, 10, 9}));
  }
  public int findUnsortedSubarray(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    int startIndex = -1;
    int endIndex = -1;
    for(int i = 0; i < nums.length - 1; i++){
      if(nums[i] > nums[i + 1]){
        if(startIndex < 0) startIndex = i;
        endIndex = i + 1;
      }
    }
    return endIndex - startIndex == 0 ? 0 : (endIndex - startIndex + 1);
  }
}
