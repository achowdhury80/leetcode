package com.prep2020.easy;

public class Problem1317 {
	public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
        	if (isNoZero(i) && isNoZero(n - i)) return new int[] {i, n - i};
        }
        return null;
    }
	
	private boolean isNoZero(int n) {
		if (n == 0) return false;
		while(n > 0) {
			if (n % 10 == 0) return false;
			n /= 10;
		}
		return true;
	}
}
