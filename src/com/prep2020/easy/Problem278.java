package com.prep2020.easy;

public class Problem278 {
	/**
	 * Log(N)
	 * @param n
	 * @return
	 */
	public int firstBadVersion(int n) {
        int low = 1, high = n;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	if (isBadVersion(mid)) high = mid;
        	else low = mid + 1;
        }
        return low;
    }
	
	private boolean isBadVersion(int version) {
		return true;
	}
}
