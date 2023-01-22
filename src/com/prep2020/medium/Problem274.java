package com.prep2020.medium;

import java.util.Arrays;

public class Problem274 {
	/**
	 * O(NLogN)
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
        	if (n - i <= citations[i]) return n - i;
        }
        return 0;
    }
}
