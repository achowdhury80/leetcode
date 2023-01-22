package com.prep2020.medium.more2000;

public class Problem2226 {
	public int maximumCandies(int[] candies, long k) {
        long count = 0;
        int max = Integer.MIN_VALUE;
        for (int i : candies) {
        	count += i;
        	max = Math.max(max, i);
        }
        int result = 0;
        long low = 1, high = Math.min(max, (count / k));
        while(low <= high) {
        	long mid = low + (high - low) / 2;
        	if (canDistribute(candies, mid, k)) {
        		low = mid + 1;
        		result = (int)mid;
        	} else high = mid - 1;
        }
        return result;
    }

	private boolean canDistribute(int[] candies, long mid, long k) {
		long step = 0;
		for (int n : candies) {
			step += n / mid;
			if (step >= k) return true;
		}
		return false;
	}
}
