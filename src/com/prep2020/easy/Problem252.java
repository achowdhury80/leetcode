package com.prep2020.easy;

import java.util.Arrays;

public class Problem252 {
	/**
	 * O(NlogN)
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals.length < 2) return true;
        Arrays.sort(intervals, (x, y) -> x[1] == y[1] ? (x[0] - y[0]) : (x[1] - y[1]));
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
        	if(intervals[i][0] < cur[1]) return false;
        	cur = intervals[i];
        }
        return true;
    }
}
