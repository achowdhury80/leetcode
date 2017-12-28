package com.leet.algo;

/**
 * Created by ayanc on 9/12/17.
 */
public class Prob485 {
  public int findMaxConsecutiveOnes(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int temp = 0;
    int result = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] == 1){
        temp++;
      } else {
        if(result < temp){
          result = temp;
          temp = 0;
        }
      }
    }
    if(temp > result) return temp;
    return result;
  }
  public static void main(String[] args){
    Prob485 prob485 = new Prob485();
    System.out.println(prob485.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
  }
}
