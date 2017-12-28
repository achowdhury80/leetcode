package com.leet.algo;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/21/17.
 */
public class Prob312 {
  public int maxCoins(int[] nums) {
    int n;
    if(nums == null || (n = nums.length) == 0) return 0;
    int[] newArray = new int[n + 2];
    if(n == 1) return nums[0];
    int[][] dp = new int[n + 2][n + 2];
    IntStream.range(0, nums.length).forEach(idx -> newArray[idx + 1] = nums[idx]);
    newArray[0] = 1;
    newArray[n + 1] = 1;
    dp[0][n - 1] = findMax(dp, newArray, 0, n + 1);
    return dp[0][n - 1];
  }

  private int findMax(int[][]dp, int[] nums, int start, int end){
    if(start + 1 == end) return 0;
    if(dp[start][end] > 0) return dp[start][end];
    int result = 0;
    for(int i = start + 1; i < end; i++){
      result = Math.max(result, nums[start] * nums[i] * nums[end] + findMax(dp, nums, start, i)
          + findMax(dp, nums, i, end));
    }
    dp[start][end] = result;
    return result;
  }

  public static void main(String[] args){
    Prob312 prob312 = new Prob312();
    System.out.println(prob312.maxCoins(new int[]{3, 1, 5, 8}));
    //System.out.println(prob312.maxCoins(new int[]{35,16,83,87,84,59,48,41,20,54}));
  }
}
