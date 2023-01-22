package com.prep2020.medium;

public class Problem714 {
	/**
	 * O(N)
	 * @param prices
	 * @param fee
	 * @return
	 */
	public int maxProfit(int[] prices, int fee) {
        long ti0 = 0, ti1 = Integer.MIN_VALUE;
        for (int p : prices) {
        	long temp = ti0;
        	ti0 = Math.max(ti0, ti1 + p - fee);
        	ti1 = Math.max(ti1, temp - p);
        }
        return (int)ti0;
    }
}
