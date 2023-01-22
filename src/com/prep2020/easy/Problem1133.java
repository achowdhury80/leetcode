package com.prep2020.easy;

public class Problem1133 {
	/**
	 * O(N)
	 * @param A
	 * @return
	 */
	public int largestUniqueNumber(int[] A) {
        int[] counts = new int[1001];
        for (int i : A) counts[i]++;
        int result = -1;
        for (int i = 1000; i > -1; i--) {
        	if (counts[i] == 1) return i;
        }
        return result;
    }
}
