package com.prep2020.medium;

public class Problem1963 {
	/**
	 * O(N)
	 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1487281/Simplest-Java-Solution-or-O(n)-Time-and-O(1)-Space-or-Explained
	 * @param s
	 * @return
	 */
	public int minSwaps(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '[') count++;
			else if (count > 0) count--;
		}
		return (count + 1) / 2;
    }
}
