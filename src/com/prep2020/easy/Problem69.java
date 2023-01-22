package com.prep2020.easy;

public class Problem69 {
	/**
	 * O(logn)
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
        int low = 0, high = x;
        while (low < high) {
        	int mid = low + (high - low) / 2;
        	long prod = 1l * mid * mid;
        	if (prod == x) return mid;
        	if (prod > x) high = mid - 1;
        	else low = mid + 1;
        }
        if (1l * low * low > x) return low - 1;
        return low;
    }
}
