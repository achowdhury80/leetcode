package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob26 {
  public int removeDuplicates(int[] nums) {
    int length = nums.length;
    for (int j = nums.length - 1; j > 0; j--) {
      if (nums[j] == nums[j - 1]){
        for (int i = j; i < length; i++) {
          nums[i] = nums[i + 1];
        }
        length--;
      }
    }
    return length;
  }
}
