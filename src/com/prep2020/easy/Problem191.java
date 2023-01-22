package com.prep2020.easy;

public class Problem191 {
	/**
	 * O(1)
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
        	result++;
        	n &= (n - 1);
        }
        return result;
    }
}
