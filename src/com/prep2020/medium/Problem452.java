package com.prep2020.medium;

import java.util.Arrays;

public class Problem452 {
	/**
	 * O(nLogn)
	 * @param points
	 * @return
	 */
	public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> x[1] == y[1] 
        		? (x[0] <= y[0] ? -1 : 1) : (x[1] <= y[1] ? -1 : 1));
        long cur = Integer.MIN_VALUE - 1l;
        int result = 0;
        for (int[] pt : points) {
        	if (pt[0] <= cur) continue;
        	result++;
        	cur = pt[1];
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem452 problem = new Problem452();
		System.out.println(problem.findMinArrowShots(new int[][] {{-2147483646,-2147483645}, {2147483646,2147483647}}));
	}
}
