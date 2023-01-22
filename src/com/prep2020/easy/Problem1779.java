package com.prep2020.easy;

public class Problem1779 {
	public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1, dis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
        	int[] pt = points[i];
        	if (pt[0] != x && pt[1] != y) continue;
        	int distance = Math.abs(pt[0] - x) + Math.abs(pt[1] - y);
        	if (distance < dis) {
        		dis = distance;
        		result = i;
        	}
        }
        return result;
    }
}
