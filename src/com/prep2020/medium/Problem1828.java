package com.prep2020.medium;

public class Problem1828 {
	/**
	 * O(m * n) m = queries.length and n = number of points
	 * @param points
	 * @param queries
	 * @return
	 */
	public int[] countPoints(int[][] points, int[][] queries) {
		int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
        	int radiusSquare = queries[i][2] * queries[i][2];
        	for (int j = 0; j < points.length; j++) {
        		int xDis = queries[i][0] - points[j][0], yDis = queries[i][1] - points[j][1];
        		if (radiusSquare >= (xDis * xDis + yDis * yDis)) result[i]++;
        	}
        }
        return result;
    }
}
