package com.prep2020.medium;

public class Problem11 {
	/**
	 * O(N)
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
        int low = 0, high = height.length - 1;
        int result = 0;
        while(low < high) {
        	result = Math.max(result, (high - low) * Math.min(height[low], 
        			height[high]));
        	if (height[high] >= height[low]) low++;
        	else high--;
        }
        return result;
    }
}
