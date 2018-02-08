package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob565 {
  public int arrayNesting(int[] nums) {
    if(nums == null || nums.length < 0) return 0;
    if(nums.length == 1) return 1;
    int result = 0;
    for (int i = 0;i < nums.length; i++) {
      int size = 0;
      for (int j = i; nums[j] > -1; ) {
        int temp = nums[j];
        nums[j] = -1;
        j = temp;
        size++;
      }
      result = Math.max(result, size);
    }
    return result;
  }



  public static void main(String[] args){
    Prob565 prob565 = new Prob565();
    System.out.println(prob565.arrayNesting(new int[]{5,4,0,3,1,6,2}));
  }
}
