package com.prep2020.medium;

import java.util.Arrays;

public class Problem435 {
	/**
	 * O(nlogN)
	 * @param intervals
	 * @return
	 */
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, 
        		(x, y) -> (x[1] == y[1] ? (y[0] - x[0]) : (x[1] - y[1])));
        int result = 0;
        int cur = Integer.MIN_VALUE;
        for (int[] intv : intervals) {
        	if (intv[0] >= cur) {
        		cur = intv[1];
        		continue;
        	}
        	result++;
        }
        return result;
    }
}
