package com.leet.algo;

/**
 * Created by ayanc on 12/6/17.
 */
public class Prob477 {
  public int totalHammingDistance(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    int result = 0;
    int k = 1;
    for(int i = 0; i < 30; i++) {
      int zeroCount = 0;
      int oneCount = 0;
      for (int j = 0; j < nums.length; j++){
        if((nums[j] & k) == 0) zeroCount++;
        else oneCount++;
      }
      result += zeroCount * oneCount;
      k *= 2;
    }
    return result;
  }

  public static void main(String[] args){
    Prob477 prob477 = new Prob477();
    System.out.println(prob477.totalHammingDistance(new int[]{4, 14, 4, 14}));
  }

}
