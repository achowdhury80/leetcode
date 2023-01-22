package com.prep2020.medium;

public class Problem1689 {
	/**
	 * O(length(N))
	 * @param n
	 * @return
	 */
	public int minPartitions(String n) {
		int result = 0;
        for (char c : n.toCharArray()) result = Math.max(result, (c - '0'));
        return result;
    }
}
