package com.prep2020.easy;

public class Problem1266 {
	/**
	 * O(N)
	 * @param points
	 * @return
	 */
	public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
        	result += distance(cur, points[i]);
        	cur = points[i];
        }
        return result;
    }
	
	private int distance(int[] pt1, int[] pt2) {
		int absX = Math.abs(pt1[0] - pt2[0]);
		int absY = Math.abs(pt1[1] - pt2[1]);
		return Math.min(absX, absY) + Math.abs(absX - absY);
	}
}
