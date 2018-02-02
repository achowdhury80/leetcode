package com.leet.algo;

/**
 * Created by ayanc on 1/29/18.
 */
public class Prob410 {
  public int splitArray(int[] nums, int m) {
    long max = nums[0];
    long[] sum = new long[nums.length];
    sum[0] = nums[0];
    for(int i = 1; i < nums.length; i++){
      sum[i] = nums[i] + sum[i - 1];
      max = Math.max(max, nums[i]);
    }
    if(m == 1) return (int)sum[nums.length - 1];
    long left = max;
    long right = sum[nums.length - 1];
    while (left <= right){
      long mid = (left + right) / 2;
      if(isValid(mid, m, sum)) right = mid - 1;
      else left = mid + 1;
    }
    return (int)left;
  }

  private boolean isValid(long target, int m, long[] sum){
    int count = 1;
    int j = -1;
    for(int i = 0; i < sum.length; i++){
      if(sum[i] - (j == -1 ? 0 :sum[j]) > target){
        count++;
        j = i - 1;
        if(count > m) return false;
      }
    }
    return true;
  }

  public static void main(String[] args){
    Prob410 prob410 = new Prob410();
    System.out.println(prob410.splitArray(new int[]{7,2,5,10,8}, 2));
  }
}
