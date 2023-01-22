package com.prep2020.medium;

import java.util.Arrays;

public class Problem1637 {
	/**
	 * O(NlogN)
	 * @param points
	 * @return
	 */
	public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (x, y) -> (x[0] - y[0]));
        int result = 0;
        int last = points[0][0];
        for (int i = 1; i < points.length; i++) {
        	result = Math.max(result, points[i][0] - last);
        	last = points[i][0];
        }
        return result;
    }
}
