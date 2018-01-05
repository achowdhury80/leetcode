package com.leet.algo;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob748 {
  public int dominantIndex(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    int result = 0;
    int nextMinValue = nums[0] * 2;
    for(int i = 1; i < nums.length; i++){
      if(nums[i] >= nextMinValue){
        result = i;
        nextMinValue = nums[i] * 2;
      } else {
        if(result > -1){
          if(nums[i] * 2 > nums[result]){
            nextMinValue = Math.max(nums[result] * 2, nums[i] * 2);
            result = -1;
          }
        } else {
          nextMinValue = Math.max(nextMinValue, nums[i] * 2);
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob748 prob748 = new Prob748();
    System.out.println(prob748.dominantIndex(new int[]{0, 0, 3, 2}));
    System.out.println(prob748.dominantIndex(new int[]{3, 6, 1, 0}));
    System.out.println(prob748.dominantIndex(new int[]{1, 2, 3, 4}));
  }
}
