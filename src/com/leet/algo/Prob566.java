package com.leet.algo;

/**
 * Created by ayanc on 8/15/17.
 */
public class Prob566 {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    if(nums == null) return null;
    if(r * c != nums.length * nums[0].length) return nums;
    int[][] result = new int[r][];
    for(int i = 0; i < result.length; i++){
      result[i] = new int[c];
    }
    for(int i = 0; i < nums.length; i++){
      for(int j = 0; j < nums[i].length; j++){
        int normalizedIndex = i * nums[0].length + j;
        int newRowIndex = normalizedIndex / c;
        int newColIndex = normalizedIndex % c;
        result[newRowIndex][newColIndex] = nums[i][j];
      }
    }
    return result;
  }
}
