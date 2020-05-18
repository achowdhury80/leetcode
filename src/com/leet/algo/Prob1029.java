package com.leet.algo;

import java.util.*;
public class Prob1029 {
	/**
	 * sort on costs[i][0] - costs[i][1]
	 * @param costs
	 * @return
	 */
	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, ((x, y) -> x[0] - y[0] - x[1] + y[1]));
        int result = 0;
        for (int i = 0; i < costs.length / 2; i++) {
        	result += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
        	result += costs[i][1];
        }
        return result;
    }
}
