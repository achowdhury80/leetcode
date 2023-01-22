package com.prep2020.hard;

public class Problem123 {
	/**
	 * O(N) time and space
	 * in the first pass, create an array to compute max profit in one transaction till the index day(it may or may not
	 * include transaction on that day. Also keep the result updated, because we may get max profit using one
	 * transaction.
	 * In the second pass, start from the right
	 * find the max profit in t the second transaction and sum it with the max profit obtained in the first pass till 
	 * previous day.
	 * keep the result updated.
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;
        int[] maxProfitTill = new int[n];
        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < n; i++) {
        	maxProfitTill[i] = Math.max(maxProfitTill[i - 1], prices[i] - minPrice);
        	minPrice = Math.min(minPrice, prices[i]);
        	result = Math.max(result, maxProfitTill[i]);
        }
        int maxPrice = prices[n - 1];
        int maxProfitForSecondTransaction = 0;
        for (int i = n - 2; i > 1; i--) {
        	maxProfitForSecondTransaction = Math.max(maxProfitForSecondTransaction, maxPrice - prices[i]);
        	result = Math.max(result, maxProfitForSecondTransaction + maxProfitTill[i - 1]);
        	maxPrice = Math.max(maxPrice, prices[i]);
        }
        return result;
    }
}
