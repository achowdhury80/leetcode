package com.prep2020.medium;

import java.util.*;

public class Problem56 {
	/**
	 * O(NlogN)
	 * @param intervals
	 * @return
	 */
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, 
        		(x, y) -> x[0] != y[0] ? (x[0] - y[0]) : (x[1] - y[1]));
        List<int[]> list = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
        	int[] next = intervals[i];
        	if (next[0] > cur[1]) {
        		list.add(cur);
        		cur = next;
        	} else {
        		cur[1] = Math.max(cur[1], next[1]);
        	}
        }
        list.add(cur);
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
