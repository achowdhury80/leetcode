package com.prep2020.medium;
import java.util.*;
public class Problem1620 {
	public int[] bestCoordinate(int[][] towers, int radius) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);
        for (int[] tower : towers) updateQueality(tower, radius, map);
        int maxQuality = 0;
        String loc = "0#0";
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	if (entry.getValue() > maxQuality) {
        		maxQuality = entry.getValue();
        		loc = entry.getKey(); 
        	} else if (entry.getValue() == maxQuality && compareLocations(loc, entry.getKey()) > 0) loc = entry.getKey();
        }
        String[] strs = loc.split("#");
        return new int[] {Integer.parseInt(strs[0]), Integer.parseInt(strs[1])};
    }

	private void updateQueality(int[] tower, int radius, Map<String, Integer> map) {
		for (int i = Math.max(0, tower[0] - radius); i <= tower[0] + radius; i++) {
			for (int j = Math.max(0, tower[1] - radius); j <= tower[1] + radius; j++) {
				double distance = findDistance(tower, new int[] {i, j});
				if (distance <= radius) {
					String loc = i + "#" + j;
					int q = map.getOrDefault(loc, 0);
					q += (int) (tower[2] / (1 + distance));
					map.put(loc, q);
				} else if (distance > radius && j >  tower[1]) break;
			}
		}
		
	}

	private double findDistance(int[] x, int[] y) {
		int xDiff = x[0] - y[0], yDiff = x[1] - y[1];
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}
	
	private int compareLocations(String s1, String s2) {
		if (s1.equals(s2)) return 0;
		String[] arr1 = s1.split("#"), arr2 = s2.split("#");
		int[] p1 = new int[] {Integer.parseInt(arr1[0]), Integer.parseInt(arr1[1])}, p2 = new int[] {Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1])};
		if (p1[0] != p2[0]) return p1[0] -p2[0];
		if (p1[1] != p2[1]) return p1[1] - p2[1];
		return 0;
	}
	
	public static void main(String[] args) {
		Problem1620 problem = new Problem1620();
		System.out.println(problem.bestCoordinate(new int[][] {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2));
	}
	
	
}
