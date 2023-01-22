package com.prep2020.hard;

import java.util.Arrays;

public class Problem1665 {
	/**
	 * O(NlogN)
	 * Greedy
	 * finish the ones early which has max gap
	 * @param tasks
	 * @return
	 */
	public int minimumEffort(int[][] tasks) {
        int min = 0, max = 0;
        for (int[] task : tasks) {
        	min += task[0];
        	max += task[1];
        }
        Arrays.sort(tasks, (x, y) -> (y[1] - y[0] == x[1] - x[0]) ? (y[1] - x[1]) 
        		: (y[1] - y[0] - x[1] + x[0]));
        while(min < max) {
        	int mid = min + (max - min) / 2;
        	if (canDo(tasks, mid)) max = mid;
        	else min = mid + 1;
        }
        
        return max;
    }

	/**
	 * O(N)
	 * 
	 * @param tasks
	 * @param min
	 * @return
	 */
	private boolean canDo(int[][] tasks, int min) {
		for (int[] task : tasks) {
			if (min < task[1]) return false;
			min -= task[0];
		}
		return true;
	}
}
