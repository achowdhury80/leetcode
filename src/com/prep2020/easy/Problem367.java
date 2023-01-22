package com.prep2020.easy;

public class Problem367 {
	/**
	 * log(N)
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
        int low = 1, high = Math.max(1, num / 2);
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	long mult = 1l * mid * mid;
        	if (mult == num) return true;
        	if (mult > num) high = mid - 1;
        	else low = mid + 1;
        }
        return false;
    }
}
