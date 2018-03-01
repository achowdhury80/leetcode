package com.leet.algo;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ayanc on 2/27/18.
 */
public class Prob45 {

  /*public int jump(int[] nums) {
    int n;
    if (nums == null || (n = nums.length) < 2) return 0;
    int[] dp = new int[n];
    dp[0] = 0;
    for (int i = 0; i < n - 1; i++) {
      int j = nums[i];
      for (int k = i + 1; k <= i + j && k < n; k++) {
        if (dp[k] == 0 || dp[k] > dp[i] + 1) dp[k] = dp[i] + 1;
      }
    }
    return dp[n - 1];
  }*/

  public int jump(int[] nums) {
    int n;
    if (nums == null || (n = nums.length) < 2) return 0;
    int level = 0, i = 0, currentMax = 0;
    int nextMax = 0;
    while (currentMax - i + 1 > 0) {
      level++;
      for (; i <= currentMax; i++) {
        if (nums[i] + i >= n - 1) return level;
        nextMax = Math.max(nextMax, nums[i] + i);
      }
      currentMax = nextMax;
    }
    return 0;
  }


  public static void main(String[] args) {
    Prob45 prob45 = new Prob45();
    System.out.println(prob45.jump(new int[]{2,3,1,1,4}));
    System.out.println(prob45.jump(new int[]{2,1}));
  }
}
