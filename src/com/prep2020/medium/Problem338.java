package com.prep2020.medium;

public class Problem338 {
	/**
	 * O(N)
	 * @param num
	 * @return
	 */
	public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num > 0) result[1] = 1;
        int last = 1;
        for (int i = 2; i <= num; i++) {
        	if ((last << 1) == i) {
        		result[i] = 1;
        		last = i;
        	} else result[i] = 1 + result[i - last];
        }
        return result;
    }
}
