package com.prep2020.easy;

public class Problem1374 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
        	sb.append('a');
        	n--;
        }
        for (int i = 0; i < n; i++) sb.append('b');
        return sb.toString();
    }
}
