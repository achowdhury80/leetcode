package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob167 {
  public int[] twoSum(int[] numbers, int target) {
    if(numbers == null || numbers.length < 2) return null;
    for (int i = 0, j = numbers.length - 1; i < j; ) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) return new int[]{i + 1, j + 1};
      if (sum > target) j--;
      else i++;
    }
    return null;
  }
}
