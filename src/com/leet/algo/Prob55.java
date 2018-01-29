package com.leet.algo;

import java.util.Map;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob55 {
  public boolean canJump(int[] nums) {
    int n;
    if (nums == null || (n = nums.length) < 1) return false;
    if (n == 1) return true;
    if (nums[0] == 0) return false;
    int last = n - 1;
    for (int i = n - 1; i > -1; i--) {
      if (nums[i] == 0) continue;
      if(i + nums[i] >= last) last = i;
    }
    return last == 0;
  }

  public static void main(String[] args){
    Prob55 prob55 = new Prob55();
    System.out.println(prob55.canJump(new int[]{2,3,1,1,4}));
    System.out.println(prob55.canJump(new int[]{3,2,1,0,4}));
  }
}
