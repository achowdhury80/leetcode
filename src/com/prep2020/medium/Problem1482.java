package com.prep2020.medium;

public class Problem1482 {
	/**
	 * O(nlog(range))
	 * @param bloomDay
	 * @param m
	 * @param k
	 * @return
	 */
	public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int d : bloomDay) {
        	low = Math.min(low, d);
        	high = Math.max(high, d);
        }
        int result = -1;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	if (canMake(bloomDay, m, k, mid)) {
        		result = mid;
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
    }

	private boolean canMake(int[] bloomDay, int m, int k, int days) {
		int start = -1;
		for (int i = 0; i < bloomDay.length && m > 0; i++) {
			if (bloomDay[i] > days) {
				if (start != -1) {
					m -= (i - start) / k;
					start = -1;
				}
			} else {
				if (start == -1) start = i;
			}
		}
		if (start != -1) m -= (bloomDay.length - start) / k;
		return m < 1;
	}
}
