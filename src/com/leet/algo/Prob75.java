package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob75 {

  public void sortColors(int[] nums) {
    if(nums == null || nums.length < 2) return;
    int[] bkt = new int[3];
    for (int i = 0; i < nums.length; i++) bkt[nums[i]]++;
    int last = -1;
    for (int i = 0; i < bkt.length; i++) {
      for (int j = 0; j < bkt[i]; j++) nums[++last] = i;
    }
  }

//  public void sortColors(int[] nums) {
//    if(nums == null || nums.length < 2) return;
//    int j = -1, k = nums.length;
//    for (int i = 0; i < k; i++) {
//      if (nums[i] == 0) {
//        swap(nums, ++j, i);
//      } else if (nums[i] == 2) swap(nums, i--, --k);
//    }
//  }

//  private void swap(int[] nums, int i, int j){
//    int temp = nums[i];
//    nums[i] = nums[j];
//    nums[j] = temp;
//  }



  public static void main(String[] args){
    Prob75 prob75 = new Prob75();
    int[] nums = new int[]{0,1,1,0,2,1,2,0,2,1};
    prob75.sortColors(nums);
    Arrays.stream(nums).forEach(x -> System.out.print(x + ", "));
    System.out.println();
    nums = new int[]{0,1};
    prob75.sortColors(nums);
    Arrays.stream(nums).forEach(x -> System.out.print(x + ", "));
  }
}
