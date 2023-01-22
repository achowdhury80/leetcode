package com.prep2020.easy;

public class Problem1720 {
	/**
	 * O(N)
	 * @param encoded
	 * @param first
	 * @return
	 */
	public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
        	first = result[i];
        	result[i + 1] = (encoded[i] ^ first);
        }
        return result;
    }
}
