package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2249 {
	public int countLatticePoints(int[][] circles) {
        Set<String> points = new HashSet<>();
        for (int[] c : circles) {
        	for (int i = c[0] - c[2]; i <= c[0] + c[2]; i++) {
        		for (int j = c[1] - c[2]; j <= c[1] + c[2]; j++) {
        			if (isInside(c, new int[] {i, j})) points.add(i + " " + j);
        		}
        	}
        }
        return points.size();
    }

	private boolean isInside(int[] circle, int[] point) {
		return (point[0] - circle[0]) * (point[0] - circle[0]) + (point[1] - circle[1]) * (point[1] - circle[1]) <= circle[2] * circle[2];
	}
}
