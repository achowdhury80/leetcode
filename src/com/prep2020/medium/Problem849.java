package com.prep2020.medium;

public class Problem849 {
	/**
	 * O(N)
	 * @param seats
	 * @return
	 */
	public int maxDistToClosest(int[] seats) {
        int result = 0, n = seats.length, future = 0, prev = -1;
        for (int i = 0; i < n; i++) {
        	if (seats[i] == 1) prev = i;
        	else {
        		while(future < n && seats[future] == 0 || future < i) 
        			future++;
        		int left = prev == -1 ? n : i - prev;
                int right = future == n ? n : future - i;
                result = Math.max(result, Math.min(left, right));
        	}
        }
        return result;
    }
}
