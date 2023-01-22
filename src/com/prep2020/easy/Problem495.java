package com.prep2020.easy;

public class Problem495 {
	/**
	 * O(N)
	 * @param timeSeries
	 * @param duration
	 * @return
	 */
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int[] last = new int[] {0, -1};
		int result = 0;
        for (int i : timeSeries) {
        	if (i > last[1]) {
        		result += last[1] - last[0] + 1;
        		last = new int[] {i, i + duration - 1};
        	} else {
        		last[1] = i + duration - 1;
        	}
        }
        result += last[1] - last[0] + 1;
        return result;
    }
}
