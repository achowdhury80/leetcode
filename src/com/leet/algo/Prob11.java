package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob11 {
  public int maxArea(int[] height) {
    if(height == null || height.length < 2) return 0;
    int result = 0;
    int low = 0, high = height.length - 1;
    while(low < high){
      result = Math.max(result, (high - low) * Math.min(height[low], height[high]));
      if(height[low] < height[high]) low++;
      else high--;
    }
    return result;
  }
}
