package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob164 {
  public int maximumGap(int[] nums) {
    int n;
    if (nums == null || (n = nums.length) < 2) return 0;
    int max = nums[0], min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }
    int gap = (int)Math.ceil((double)(max - min) / (n - 1));
    int[] min_bucket = new int[n - 1];
    int[] max_bucket = new int[n - 1];
    Arrays.fill(min_bucket, Integer.MAX_VALUE);
    Arrays.fill(max_bucket, Integer.MIN_VALUE);
    for (int num : nums) {
      if (num == min || num == max) continue;
      int idx = (num - min) / gap;
      min_bucket[idx] = Math.min(min_bucket[idx], num);
      max_bucket[idx] = Math.max(max_bucket[idx], num);
    }
    int maxGap = Integer.MIN_VALUE;
    int previous = min;
    for (int i = 0; i < n - 1; i++) {
      if (max_bucket[i] == Integer.MIN_VALUE && min_bucket[i] == Integer.MAX_VALUE) continue;
      maxGap = Math.max(maxGap, min_bucket[i] - previous);
      previous = max_bucket[i];
    }
    maxGap = Math.max(maxGap, max - previous);
    return maxGap;
  }
}
