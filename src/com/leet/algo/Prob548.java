package com.leet.algo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob548 {
  public boolean splitArray(int[] nums) {
    if (nums.length < 7) return false;
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    IntStream.range(1, nums.length).forEach(idx -> dp[idx] = dp[idx - 1] + nums[idx]);
    for (int i = 3; i < nums.length - 3; i++) if (split1(nums, i, dp)) return true;
    return false;
  }

  private boolean split1(int[] nums, int middle, int[] dp) {
    Integer partSum = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 1; i < middle - 1; i++) if (dp[i - 1] == dp[middle - 1] - dp[i]) set.add(dp[i - 1]);
    for (int j = middle + 2; j < nums.length - 1; j++)
      if (set.contains(dp[j - 1] - dp[middle]) && dp[j - 1] - dp[middle] == dp[nums.length - 1] - dp[j]) return true;
    return false;
  }

  public static void main(String[] args) {
    Prob548 prob548 = new Prob548();
    System.out.println(prob548.splitArray(new int[]{1,2,1,2,1,2,1}));
  }
}
