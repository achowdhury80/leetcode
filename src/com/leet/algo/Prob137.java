package com.leet.algo;

import com.sun.istack.internal.ByteArrayDataSource;

/**
 * Created by ayanc on 11/6/17.
 */
public class Prob137 {
  public int singleNumber(int[] nums) {
    int result = 0;
    for(int i = 0; i < 32; i++){
      int mask = 1 << i;
      int zeros = 0;
      int ones = 0;
      for(int j = 0; j < nums.length; j++){
        if((mask & nums[j]) != 0) ones++;
        else zeros++;
      }
      if(ones % 3 == 1) result = (result | mask);
    }
    return result;
  }

  public static void main(String[] args){
    Prob137 prob137 = new Prob137();
    System.out.println(prob137.singleNumber(new int[]{1,3,2,4,3,2,3,1, 2, 1}));
    System.out.println(prob137.singleNumber(new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2}));

  }


}
