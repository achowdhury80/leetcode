package com.prep2020.easy;

public class Problem461 {
	/**
	 * O(1)
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int result = 0;
        while(xor > 0) {
        	result++;
        	xor &= (xor - 1);
        }
        return result;
    }

}
