package com.prep2020.easy;

public class Problem1281 {
	/**
	 * O(logn)  -- base 10
	 * @param n
	 * @return
	 */
	public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while(n > 0) {
        	int digit = n % 10;
        	n /= 10;
        	product *= digit;
        	sum += digit;
        }
        return product - sum;
    }
}
