package com.prep2020.easy;

public class Problem204 {
	/**
	 * 
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
        int result = 0;
        if (n == 0) return 0;
        boolean[] notPrime = new boolean[n + 1];
        notPrime[1] = true;
        for (int i = 2; i < n; i++) {
        	if (!notPrime[i]) {
        		result++;
        		for (int j = 2 * i; j < n; j += i) {
        			notPrime[j] = true;
        		}
        	}
        }
        return result;
    }
}
