package com.leet.algo;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob713 {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k < 1) return 0;
    int result = 0;
    int left = 0, right = 0;
    long product = 1;
    while (right < nums.length) {
      if (nums[right] >= k) {
        left = right + 1;
        product = 1;
        right++;
        continue;
      }
      if (left == right) {
        product = nums[left];
        result++;
      }
      else {
        product *= nums[right];
        while (product >= k) {
          product /= nums[left];
          left++;
        }
        result += right - left + 1;
      }
      right++;
    }

    return result;
  }

  public static void main(String[] args){
    Prob713 prob713 = new Prob713();
//    System.out.println(prob713.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
//    System.out.println(prob713.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    System.out.println(prob713.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));

  }
}
