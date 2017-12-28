package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/23/17.
 */
public class Prob152 {


  public int maxProduct(int[] nums) {
    int n;
    if(nums == null || (n = nums.length) == 0) return 0;
    if(n == 1) return nums[0];

    int result = nums[0];
    int maxHere, minHere;
    int maxBefore = nums[0];
    int minBefore = nums[0];
    for(int i = 1; i < n; i++){
      maxHere = Math.max(Math.max(maxBefore * nums[i], minBefore * nums[i]), nums[i]);
      minHere = Math.min(Math.min(maxBefore * nums[i], minBefore * nums[i]), nums[i]);
      result = Math.max(result, maxHere);
      maxBefore = maxHere;
      minBefore = minHere;
    }

    return result;
  }





  public static void main(String[] args){
    Prob152 prob152 = new Prob152();
    System.out.println(prob152.maxProduct(new int[]{2,3,-2,4}));
    System.out.println(prob152.maxProduct(new int[]{-4, -3, -2}));
    System.out.println(prob152.maxProduct(new int[]{-2}));
    System.out.println(prob152.maxProduct(new int[]{0, 2}));
  }
}
