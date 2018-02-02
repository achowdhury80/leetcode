package com.leet.algo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 2/1/18.
 */
public class Prob493 {
  public int reversePairs(int[] nums) {
    int n;
    if(nums == null || (n = nums.length) < 1) return 0;
    return reversePairsSum(nums, 0, n - 1);
  }

  private int reversePairsSum(int[] nums, int left, int right){
    if (left >= right) return 0;
    int mid = left + ((right - left) >> 2);
    int result = reversePairsSum(nums, left, mid) + reversePairsSum(nums, mid + 1, right);
    int[] merged = new int[right - left + 1];
    int i = left, j = mid + 1, p = mid + 1, k = 0;

    while (i <= mid){
      while (p <= right && nums[i] > 2l * nums[p]) p++;
      result += p - mid - 1;
      while (j <= right && nums[i] >= nums[j]) merged[k++] = nums[j++];
      merged[k++] = nums[i++];
    }
    while (j <= right) merged[k++] = nums[j++];
    System.arraycopy(merged, 0, nums, left, merged.length);
    return result;
  }

  public static void main(String[] args){
    Prob493 prob493 = new Prob493();
    System.out.println(prob493.reversePairs(new int[]{1,3,2,3,1}));
    System.out.println(prob493.reversePairs(new int[]{2,4,3,5,1}));
    System.out.println(prob493.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));

  }


}
