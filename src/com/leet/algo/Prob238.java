package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/3/17.
 */
public class Prob238 {
  int leftProd = 1;
  int rightProd = 1;
  public int[] productExceptSelf(int[] nums) {
    if(nums == null || nums.length == 0) return new int[]{};
    int[] result = Arrays.stream(new int[nums.length]).map(i -> 1).toArray();
    for(int i = 0; i < nums.length; i++){
      leftProd *= (i == 0 ? 1 : nums[i - 1]);
      rightProd *= (i == 0 ? 1 : nums[nums.length - i]);
      result[i] *= leftProd;
      result[nums.length - 1 - i] *= rightProd;
    }

    Arrays.stream(result).forEach(System.out::println);
    return result;
  }

  public static void main(String[] args){
    Prob238 prob238 = new Prob238();
    prob238.productExceptSelf(new int[]{1, 2, 3, 4});
  }
}
