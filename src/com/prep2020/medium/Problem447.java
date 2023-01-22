package com.prep2020.medium;
import java.util.*;
public class Problem447 {
	/**
	 * O(N^2)
	 * @param points
	 * @return
	 */
	public int numberOfBoomerangs(int[][] points) {
        int n = points.length, result = 0;
        for (int i = 0; i < n; i++) {
        	Map<Integer, Integer> map = new HashMap<>();
        	for (int j = 0; j < n; j++) {
        		if (i == j) continue;
        		int dis = (points[i][0] - points[j][0]) 
        				* (points[i][0] - points[j][0])
        				+ (points[i][1] - points[j][1]) 
        				* (points[i][1] - points[j][1]);
        		map.put(dis, map.getOrDefault(dis, 0) + 1);
        	}
        	for (int val : map.values()) {
        		if (val > 1) result += val * (val - 1);
        	}
        }
        return result;
    }
}
