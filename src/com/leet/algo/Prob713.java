package com.leet.algo;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob713 {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if(nums.length < 2) return nums[0] < k ? 1 : 0;
    long[] prod = new long[nums.length];
    int result = 0;
    prod[0] = nums[0];
    int lastIndex = 0;
    if(nums[0] < k) result++;
    else lastIndex++;
    for(int i = 1; i < nums.length; i++) {
      prod[i] = prod[i - 1] * nums[i];
      if (prod[i] < k) {
        result += i + 1;
        continue;
      }
      if (nums[i] >= k) {
        lastIndex = i;
        continue;
      }
      if(prod[i] / prod[lastIndex] < k) {
        result += (i - lastIndex);
        continue;
      }
      while (lastIndex < i && prod[i] / prod[lastIndex] >= k) {
        lastIndex++;
      }
      if (lastIndex == i) result++;
      else {
        result += i - lastIndex;
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob713 prob713 = new Prob713();
    //System.out.println(prob713.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    System.out.println(prob713.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));

  }
}
