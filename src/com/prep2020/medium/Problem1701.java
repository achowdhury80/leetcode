package com.prep2020.medium;

public class Problem1701 {
	/**
	 * O(N)
	 * @param customers
	 * @return
	 */
	public double averageWaitingTime(int[][] customers) {
		double wait = 0, start = 0;
        for (int[] c : customers) {
        	start = Math.max(c[0], start);
        	double finish = start + c[1];
        	wait += finish - c[0];
        	start = finish;
        }
        return wait / customers.length;
    }
}
