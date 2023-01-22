package com.prep2020.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem939 {
	/**
	 * O(n^2)
	 * @param points
	 * @return
	 */
	public int minAreaRect(int[][] points) {
        int result = Integer.MAX_VALUE;
        List<Line> xlines = new ArrayList<>();
        for (int i = 0; i < points.length - 1; i++) {
        	for (int j = i + 1; j < points.length; j++) {
        		if (points[i][1] == points[j][1]) xlines.add(
        			new Line(points[i][0], points[j][0], points[i][1]));
        	}
        }
        xlines.sort((x, y) -> (x.x1 != y.x1) ? (x.x1 - y.x1) 
        		: ((x.x2 != y.x2) ? (x.x2 - y.x2) : (x.y - y.y)));
        for (int i = 1; i < xlines.size(); i++) {
        	if (xlines.get(i - 1).x1 == xlines.get(i).x1 
        			&& xlines.get(i - 1).x2 == xlines.get(i).x2) {
        		int y = Math.max(xlines.get(i - 1).y, xlines.get(i).y)
        				- Math.min(xlines.get(i - 1).y, xlines.get(i).y);
        		int x = xlines.get(i).x2 - xlines.get(i).x1;
				result = Math.min(y * x, result);
        	}
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
	
	class Line {
        int x1;
        int x2;
        int y;
        Line(int x1, int x2, int y) {
            this.x1 = Math.min(x2, x1);
            this.x2 = Math.max(x2, x1);
            this.y = y;
        }
    }
}
