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
    int n;
    if (nums == null || (n = nums.length) < 2) return 0;
    int max = nums[0], min = nums[n - 1];
    int end = -2;
    int begin = -1;
    for (int i = 1; i < n; i++) {
      if (nums[i] < max) {
        end = i;
        max = nums[i];
      }
      if (nums[n - i - 1] > min) {
        begin = n - i -1;
      } else min = nums[n - i -1];
    }
    return end - begin + 1;
  }
}
