package com.prep2020.easy;

public class Problem374 {
	/**
	 * O(logN)
	 * @param n
	 * @return
	 */
	public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
        	int mid = low + (high - low) / 2;
        	int ret = guess(mid);
        	if (ret == 0) return mid;
        	if (ret < 0) high = mid - 1;
        	else low = mid + 1;
        }
        return -1;
    }
	
	private int guess(int num) {
		return 0;
	}
}
