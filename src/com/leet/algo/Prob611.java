package com.leet.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob611 {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int count = 0, n = nums.length;
    for (int i=n-1;i>=2;i--) {
      int l = 0, r = i-1;
      while (l < r) {
        if (nums[l] + nums[r] > nums[i]) {
          count += r-l;
          r--;
        }
        else l++;
      }
    }
    return count;
  }

  public static void main(String[] args){
    Prob611 prob611 = new Prob611();
    System.out.println(prob611.triangleNumber(new int[]{2,2,3, 4}));
    System.out.println(prob611.triangleNumber(new int[]{0, 1, 1, 1}));
  }
}
