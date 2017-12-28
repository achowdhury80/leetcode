package com.leet.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/22/17.
 */
public class Prob416 {
  public boolean canPartition(int[] nums) {
    int n;
    if(nums == null || (n = nums.length) == 0 || n == 1){
      return false;
    }
    int sum = Arrays.stream(nums).sum();
    if(sum % 2 != 0) return false;
    int target = sum / 2;
    boolean[][] dp = new boolean[target + 1][n + 1];
    IntStream.range(1, n + 1).forEach(x -> dp[0][x] = true);
    IntStream.range(1, target + 1).forEach(x -> dp[x][0] = false);
    IntStream.range(1, target + 1).forEach(i -> {
      IntStream.range(1, n + 1).forEach(j -> {
        dp[i][j] = dp[i][j - 1];
        if(i >= nums[j - 1]) dp[i][j] = dp[i][j] || dp[i - nums[j - 1]][j - 1];
      });
    });

    return dp[target][n];
  }

  public static void main(String[] args){
    Prob416 prob416 = new Prob416();
    System.out.println(prob416.canPartition(new int[]{1, 5, 11, 5}));
    System.out.println(prob416.canPartition(new int[]{1, 2, 3, 5}));
  }
}
