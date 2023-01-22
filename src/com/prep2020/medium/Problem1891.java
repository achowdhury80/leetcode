package com.prep2020.medium;

public class Problem1891 {
	/**
	 * O(nlogn)
	 * @param ribbons
	 * @param k
	 * @return
	 */
	public int maxLength(int[] ribbons, int k) {
        long sum = 0;
        for (int i : ribbons) sum += i;
        if (k > sum) return 0;
        if (2 * k > sum) return 1;
        long result = 1, low = 2, high = sum / k;
        while (low <= high) {
        	long mid = low + (high - low) / 2;
        	if (possible(ribbons, mid, k)) {
        		result = mid;
        		low = mid + 1;
        	} else high = mid - 1;
        }
        return (int)result;
    }

	private boolean possible(int[] ribbons, long mid, int k) {
		long parts = 0;
		for (int i : ribbons) parts += i / mid;
		return parts >= k;
	}
}
