package com.prep2020.easy;

public class Problem1837 {
	/**
	 * logN
	 * @param n
	 * @param k
	 * @return
	 */
	public int sumBase(int n, int k) {
		int result = 0;
        while(n > 0) {
        	result += n % k;
        	n /= k;
        }
        return result;
    }
}
