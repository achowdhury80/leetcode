package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2280 {
	public int minimumLines(int[][] stockPrices) {
		int n = stockPrices.length;
		if (n < 3) return n -1;
        Arrays.sort(stockPrices, (x, y) -> x[0] - y[0]);
        int result = 1;
        long[] numerAndDenom = findNumerAndDenom(stockPrices[0], stockPrices[1]);
        for (int i = 2; i < n; i++) {
        	long[] newNumerAndDenom = findNumerAndDenom(stockPrices[i - 1], stockPrices[i]);
        	if (numerAndDenom[0] * newNumerAndDenom[1] != numerAndDenom[1] * newNumerAndDenom[0]) {
        		result++;
        		numerAndDenom = newNumerAndDenom;
        	}
        }
        return result;
    }
	
	private long[] findNumerAndDenom(int[] x, int[] y) {
		return new long[] {0l + y[1] - x[1], 0l + y[0] - x[0]};
	}
}
