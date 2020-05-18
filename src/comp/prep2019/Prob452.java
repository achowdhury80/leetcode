package comp.prep2019;

import java.util.Arrays;

public class Prob452 {
	public int findMinArrowShots(int[][] points) {
		if (points.length < 1) return 0;
        Arrays.sort(points, (x, y) -> (x[1] == y[1]) ? (x[0] - y[0]) : (x[1] - y[1]));
        int result = 0;
        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
        	if (cur[1] < points[i][0]) {
        		result++;
        		cur = points[i];
        	} else {
        		cur = new int[] { Math.max(cur[0], points[i][0]), 
        				Math.min(cur[1], points[i][1])};
        	}
        }
		result++;
        return result;
    }
}
