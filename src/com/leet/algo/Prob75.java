package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob75 {
  public void sortColors(int[] nums) {
    if(nums == null || nums.length < 2) return;
    int cur = -1;
    for(int i = 0; i < 2; i++){
      int nextNonI = nextNonColor(i, cur, nums);
      while(nextNonI > -1) {
        int nextI = nextPos(i, nextNonI, nums);
        if (nextI == -1) break;
        swap(nums, nextNonI, nextI);
        cur = nextNonI;
        nextNonI = nextNonColor(i, nextNonI, nums);
      }
      if(cur == -1 && nextNonI > -1){
        cur = nextNonI - 1;
      }
    }
  }

  private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private int nextPos(int color, int cur, int[] nums){
    for(int i = cur + 1; i < nums.length; i++){
      if(nums[i] == color) return i;
    }
    return -1;
  }

  private int nextNonColor(int color, int cur, int[] nums){
    for(int i = cur + 1; i < nums.length; i++){
      if(nums[i] != color) return i;
    }
    return -1;
  }

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
