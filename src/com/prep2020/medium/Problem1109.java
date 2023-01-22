package com.prep2020.medium;

public class Problem1109 {
	/**
	 * O(N)
	 * @param bookings
	 * @param n
	 * @return
	 */
	public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
        	result[booking[0] - 1] += booking[2];
        	if (booking[1] < n)  result[booking[1]] -= booking[2];
        }
        int last = 0;
        for (int i = 0; i < n; i++) {
        	last += result[i];
        	result[i] = last;
        }
        return result;
    }
}
