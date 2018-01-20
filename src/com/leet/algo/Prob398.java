package com.leet.algo;

import java.util.Random;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob398 {
  int[] nums;
  public Prob398(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    int r = -1;
    int count = 0;
    Random random = new Random();
    for(int i = 0; i < nums.length; i++){
      if(nums[i] == target){
        count++;
        if(r == -1) r = i;
        else {
          if(random.nextInt(count + 1) == count - 1) r = i;
        }
      }
    }
    return r;
  }
}
