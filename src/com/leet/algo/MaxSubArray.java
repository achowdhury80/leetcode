package com.leet.algo;

import java.math.BigInteger;

/**
 * ind the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray {
  public int maxSubArray(int[] nums) {
    return maxSum(nums, 0, nums.length - 1);
  }

  private int maxSum(int[] nums, int lowerIndex, int upperIndex){
    if(lowerIndex == upperIndex) return nums[upperIndex];
    if(lowerIndex > upperIndex || upperIndex < lowerIndex) return 0;
    int mid = (lowerIndex + upperIndex) / 2;
    int leftSum = maxSum(nums, lowerIndex, mid);
    int rightSum = maxSum(nums, mid + 1, upperIndex);
    int leftMax = nums[mid];
    int temp = 0;
    for(int i = mid; i >= lowerIndex; i--){
      temp += nums[i];
      if(temp > leftMax) leftMax = temp;
    }
    temp = 0;
    int rightMax = nums[mid + 1];
    for(int i = mid + 1; i <= upperIndex; i++){
      temp += nums[i];
      if(temp > rightMax) rightMax = temp;
    }
    int midSum = leftMax + rightMax;
    if(leftSum >= rightSum && leftSum >= midSum) return leftSum;
    if(rightSum >= leftSum && rightSum >= midSum) return rightSum;
    return midSum;
  }
  public static void main(String[] args){
    //System.out.println(new MaxSubArray().maxSubArray(new int[]{-1,-1,-2,-2}));
    System.out.println(findNChooseR(4, 2));

  }

  private static int findNChooseR(int n, int r){
    if(n == 0 || r == 0) return 1;
    if(r == 1 || r == n - 1) return n;
    BigInteger ret = BigInteger.ONE;
    for(int k = 0; k < r; k++){
      ret = ret.multiply(BigInteger.valueOf(n - k)).divide(BigInteger.valueOf(k + 1));
    }
    return ret.intValue();
  }
}
