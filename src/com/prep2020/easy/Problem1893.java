package com.prep2020.easy;

import java.util.Arrays;

public class Problem1893 {
	/**
	 * O(NlogN)
	 * @param ranges
	 * @param left
	 * @param right
	 * @return
	 */
	public boolean isCovered(int[][] ranges, int left, int right) {
		Arrays.sort(ranges, (x, y) -> (x[0] == y[0] ? (x[1] - y[1]) : (x[0]- y[0])));
        int j = 0;
		for (int i = left; i <= right; i++) {
        	while(j < ranges.length && ranges[j][1] < i) j++;
        	if (j == ranges.length || ranges[j][0] > i) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem1893 problem = new Problem1893();
		System.out.println(problem.isCovered(new int[][] {{25,42},{7,14},{2,32},{25,28},{39,49},{1,50},{29,45},{18,47}},15,38));
	}
}
