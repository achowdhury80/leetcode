package com.prep2020.medium;

import java.util.Arrays;

public class Problem1833 {
	/**
	 * O(NlogN)
	 * @param costs
	 * @param coins
	 * @return
	 */
	public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        for (int i = 0; i < costs.length && coins > 0; i++) {
        	if (costs[i] <= coins) {
        		coins -= costs[i];
        		result++;
        	} else break;
        }
        return result;
    }
}
