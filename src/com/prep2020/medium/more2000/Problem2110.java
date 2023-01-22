package com.prep2020.medium.more2000;

public class Problem2110 {
	/**
	 * O(n)
	 * @param prices
	 * @return
	 */
	public long getDescentPeriods(int[] prices) {
        int start = 0;
        long result = 1;
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] + 1 != prices[i - 1]) {
        		start = i;
        		result++;
        	} else result += (i - start + 1);
        }
        return result;
    }
}
