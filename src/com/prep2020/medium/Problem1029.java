package com.prep2020.medium;

import java.util.Arrays;

public class Problem1029 {
	/**
	 * O(nlogN)
	 * @param costs
	 * @return
	 */
	public int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
        Arrays.sort(costs, (x, y) -> (x[0] - x[1] - y[0] + y[1]));
        int result = 0;
        for (int i = 0; i < n; i++) {
        	if (i < n / 2) result += costs[i][0];
        	else result += costs[i][1];
        }
        return result;
    }
}
