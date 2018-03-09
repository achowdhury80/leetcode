package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob26 {
  public int removeDuplicates(int[] nums) {
    if (nums == null) return 0;
    int cur = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[cur]) continue;
      nums[++cur] = nums[i];
    }
    return cur + 1;
  }
}
