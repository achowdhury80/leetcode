package com.leet.algo;

/**
 * Created by ayanc on 2/27/18.
 */
public class Prob330 {
  public int minPatches(int[] nums, int n) {
    long miss = 1;
    int i = 0, added = 0;
    while (miss <= n) {
      if (i < nums.length && nums[i] <= miss) {
        miss += nums[i];
        i++;
      } else {
        miss += miss;
        added++;
      }
    }
    return added;
  }
}
