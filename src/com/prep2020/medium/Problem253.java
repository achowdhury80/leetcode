package com.prep2020.medium;
import java.util.*;
public class Problem253 {
	/**
	 * O(N) time and space
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[][] parts = new int[2 * n][2];
        int idx = 0;
        for (int[] intv : intervals) {
        	parts[idx++] = new int[] {intv[0], 0};
        	parts[idx++] = new int[] {intv[1], 1};
        }
        Arrays.sort(parts, (x, y) -> (x[0] == y[0] && (x[1] != y[1]) ? (y[1] - x[1]) : (x[0] - y[0])));
        int result = 0, cur = 0;
        for (int i = 0; i < parts.length; i++) {
        	if (parts[i][1] == 0) {
        		cur++;
        		result = Math.max(result, cur);
        	} else cur--;
        }
        return result;
    }
}
