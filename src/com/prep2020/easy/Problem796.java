package com.prep2020.easy;

public class Problem796 {
	/**
	 * O(N^2) time and O(N) space
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).indexOf(B) > -1;
    }
}
