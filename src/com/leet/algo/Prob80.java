package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob80 {
  public int removeDuplicates(int[] nums) {
    if(nums == null) return 0;
    if(nums.length < 3) return nums.length;
    int cur = 1;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] == nums[cur - 1]) continue;
      nums[++cur] = nums[i];
    }
    return cur + 1;
  }



  public static void main(String[] args){
    int[] nums;
    nums = new int[]{1,1,1,2,2,3};
    Prob80 prob80 = new Prob80();
    System.out.println(prob80.removeDuplicates(nums));
    Arrays.stream(nums).forEach(x -> System.out.print(x + ", "));
  }
}
