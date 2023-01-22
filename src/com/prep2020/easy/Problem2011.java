package com.prep2020.easy;

public class Problem2011 {
	/**
	 * O(N)
	 * @param operations
	 * @return
	 */
	public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String op : operations) {
        	if (op.charAt(1) == '+') result++;
        	else result--;
        }
        return result;
    }
}
