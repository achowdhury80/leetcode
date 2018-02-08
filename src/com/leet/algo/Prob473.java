package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 2/4/18.
 */
public class Prob473 {
  public boolean makesquare(int[] nums) {
    if (nums == null || nums.length < 4) return false;
    int sum = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        max = Math.max(max, nums[i]);
        sum += nums[i];
      }
    }
    if (sum % 4 != 0) return false;
    int side = sum / 4;
    if (max > side) return false;
    Arrays.sort(nums);
    return dfs(nums, nums.length - 1, new int[]{side, side, side, side});
  }

  private boolean dfs(int[] nums, int i, int[] sides) {
    if (i < 0) return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
    for (int j = 0; j < sides.length; j++) {
      if (nums[i] > sides[j]) continue;
      sides[j] -= nums[i];
      if (dfs(nums, i - 1, sides)) return true;
      sides[j] += nums[i];
    }
    return false;
  }

  public static void main(String[] args) {
    Prob473 prob473 = new Prob473();
    System.out.println(prob473.makesquare(new int[]{1,1,2,2,2}));
    System.out.println(prob473.makesquare(new int[]{3,3,3,3,4}));

    System.out.println(prob473.makesquare(new int[]{99,37,37,37,37,37,37,37,37,5}));
  }
}
