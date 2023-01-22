package com.prep2020.easy;

public class Problem806 {
	/**
	 * O(N)
	 * @param widths
	 * @param s
	 * @return
	 */
	public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        for (char c : s.toCharArray()) {
        	int w = widths[c - 'a'];
        	if (result[1] + w > 100) {
        		result[0]++;
        		result[1] = w;
        	} else result[1] += w;
        }
        if (result[1] > 0) result[0]++;
        return result;
    }
}
