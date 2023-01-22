package com.prep2020.easy;

public class Problem1051 {
	/**
	 * O(N)
	 * @param heights
	 * @return
	 */
	public int heightChecker(int[] heights) {
        int[] counts = new int[101];
        for (int h : heights) counts[h]++;
        
        for (int i = 1; i < counts.length; i++) counts[i] += counts[i - 1];
        
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
        	int minPos = counts[heights[i] - 1];
        	int maxPos = counts[heights[i]] - 1;
        	if (i < minPos || i > maxPos) result++;
        }
        return result;
    }
}
