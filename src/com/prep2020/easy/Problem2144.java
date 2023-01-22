package com.prep2020.easy;

import java.util.Arrays;

public class Problem2144 {
	/**
	 * O(nlogn)
	 * @param cost
	 * @return
	 */
	public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int result = 0;
        int freeWait = 2;
        for (int i = cost.length - 1; i > -1; i--) {
        	if (freeWait == 0) {
        		freeWait = 2;
        	} else {
        		result += cost[i];
        		freeWait--;
        	}
        }
        return result;
    }
}
