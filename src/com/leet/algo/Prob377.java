package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 12/18/17.
 */
public class Prob377 {

  public int combinationSum4(int[] nums, int target) {
    if(target == 0 || nums == null || nums.length == 0) return 0;
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for(int i = 1; i < dp.length; i++) dp[i] = -1;
    return findWays(dp, nums, target);
  }

  private int findWays(int[] dp, int[] nums, int target){
    if(target == 0) return 1;
    if(dp[target] != -1) return dp[target];
    int result = 0;
    for(int i = 0; i < nums.length; i++){
      int newTarget = target - nums[i];
      if(newTarget < 0) continue;
      int right = findWays(dp, nums, newTarget);
      result += right;
    }
    //System.out.println("dp[" + target + "]: " + result);
    dp[target] = result;
    return dp[target];
  }

  public static void main(String[] arhs){
    Prob377 prob377 = new Prob377();
    System.out.println(prob377.combinationSum4(new int[]{1, 2, 3}, 4));
    System.out.println(prob377.combinationSum4(new int[]{9}, 3));
    System.out.println(prob377.combinationSum4(new int[]{1, 2}, 3));
    System.out.println(prob377.combinationSum4(new int[]{3,4,5,6,7,8,9,10}, 4));
    System.out.println(prob377.combinationSum4(new int[]{3,4,5,6,7,8,9,10}, 10));
    System.out.println(prob377.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10));
    System.out.println(prob377.combinationSum4(new int[]{3,33,333}, 10000));

  }

}
