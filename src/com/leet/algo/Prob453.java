package com.leet.algo;

/**
 * Created by ayanc on 10/23/17.
 */
public class Prob453 {
  public int minMoves(int[] nums) {
    if(nums == null || nums.length < 2) return 0;
    int min = Integer.MAX_VALUE;
    long sum = 0l;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] < min) min = nums[i];
      sum += nums[i];
    }
    int move = 0;
    while(sum != nums.length * min){
      sum += (nums.length - 1);
      min++;
      move++;
    }
    return move;
  }

  public static void main(String[] args){
    Prob453 prob453 = new Prob453();
    System.out.println(prob453.minMoves(new int[]{1,3,6, 7}));
  }
}
