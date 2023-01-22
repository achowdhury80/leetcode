package com.prep2020.easy;

public class Problem1037 {
	/**
	 * O(1)
	 * @param points
	 * @return
	 */
	public boolean isBoomerang(int[][] points) {
        if ((points[0][0] == points[1][0] && points[0][1] == points[1][1])
        		|| (points[1][0] == points[2][0] && points[1][1] == points[2][1])
        		|| (points[2][0] == points[0][0] && points[2][1] == points[0][1])) 
        	return false;
        return (points[0][1] - points[1][1]) * (points[1][0] - points[2][0])
        		!= (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]);
    }
}
