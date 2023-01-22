package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2152 {
	public int minimumLines(int[][] points) {
		List<int[]> list = new ArrayList<>();
		for (int[] p : points) list.add(p);
		return helper(list);
    }
	
	private double findSlope(int[] x, int[] y) {
		if (x[0] == y[0]) return Double.MAX_VALUE;
		return (0. + x[1] - y[1]) / (x[0] - y[0]);
	}
	
	private int helper(List<int[]> points) {
		int minExternal = Integer.MAX_VALUE;
		for (int i = 0; i < points.size(); i++) {
			int minInternal = Integer.MAX_VALUE;
			for (int j = i + 1; j < points.size(); j++) {
				int count = 1;
				double slope = findSlope(points.get(i), points.get(j));
				List<int[]> notInLine = new ArrayList<>();
				for (int k = 0; k < points.size(); k++) {
					if (i == k || j == k) continue;
					if (slope != findSlope(points.get(i), points.get(k))) 
						notInLine.add(points.get(k));
				}
				if (notInLine.size() > 0) count += helper(notInLine);
				minInternal = Math.min(minInternal, count);
			}
			minExternal = Math.min(minExternal, minInternal);
		}
		return minExternal == Integer.MAX_VALUE ? 1 : minExternal;
	}
}
