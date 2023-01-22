package com.prep2020.medium;

import java.util.Arrays;

public class Problem646 {
	/**
	 * O(NLogN)
	 * @param pairs
	 * @return
	 */
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (x, y) -> (x[1] == y[1]) ? (x[0] - y[0]) : (x[1] - y[1]));
        int result = 1;
        int curEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
        	if (pairs[i][0] > curEnd) {
        		result++;
        		curEnd = pairs[i][1];
        	}
        }
        return result;
    }
}
