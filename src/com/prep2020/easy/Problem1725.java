package com.prep2020.easy;

public class Problem1725 {
	public int countGoodRectangles(int[][] rectangles) {
        int result = 0, maxLen = 0;
        for (int[] rect : rectangles) {
        	int len = Math.min(rect[0], rect[1]);
        	if (maxLen < len) {
        		result = 1;
        		maxLen = len;
        	} else if (maxLen == len) {
        		result++;
        	}
        }
        return result;
    }
}
