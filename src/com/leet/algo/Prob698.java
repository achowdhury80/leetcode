package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/24/17.
 */
public class Prob698 {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int n;
    if(k < 2) return true;
    if(nums == null || (n = nums.length) == 0) return false;
    int sum = 0;
    for(int i : nums) sum += i;
    if(sum % k != 0 || sum < k) return false;
    sum /= k;
    Arrays.sort(nums);
    return isPossible(nums, sum, new int[k], nums.length - 1);
  }

  private boolean isPossible(int[] nums, int sum, int[] subsetSum, int lastIndex){
    if(lastIndex == -1){
      for (int s : subsetSum) if (s != sum) return false;
      return true;
    }
    int num = nums[lastIndex];
    for(int i = 0; i < subsetSum.length; i++){
      if(sum - subsetSum[i] >= num){
        subsetSum[i] += num;
        if(isPossible(nums, sum, subsetSum, lastIndex - 1)) return true;
        subsetSum[i] = subsetSum[i] - num;
      }
    }
    return false;
  }

  public static void main(String[] args){
    Prob698 prob698 = new Prob698();
    //System.out.println(prob698.canPartitionKSubsets(new int[]{4,15,1,1,1,1,3,11,1,10}, 3));
    System.out.println(prob698.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
  }


}
