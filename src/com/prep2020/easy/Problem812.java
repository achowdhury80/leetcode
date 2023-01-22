package com.prep2020.easy;

public class Problem812 {
	/**
	 * O(N^3)
	 * @param points
	 * @return
	 */
	public double largestTriangleArea(int[][] points) {
	    double result = 0;
	    for (int i = 0; i < points.length; i++) {
	      for (int j = 0; j < points.length; j++) {
	        for (int k = 0; k < points.length; k++) {
	          result = Math.max(result, Math.abs(
	              0.5 * (points[i][0] * (points[j][1] - points[k][1])
	                  + points[j][0] * (points[k][1] - points[i][1])
	              + points[k][0] * (points[i][1] - points[j][1])
	              )));
	        }
	      }
	    }
	    return result;
	  }
}
