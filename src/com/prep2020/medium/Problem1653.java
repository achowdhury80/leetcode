package com.prep2020.medium;

public class Problem1653 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int minimumDeletions(String s) {
		int n = s.length(), allBCount = 0, result = Integer.MAX_VALUE;
        for (int i = n - 1; i > -1; i--) {
        	if (s.charAt(i) == 'a') allBCount++;
        }
        result = Math.min(result, allBCount); // all bs
        int allAcount = 0;
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == 'a') {
        		allBCount--;
        		result = Math.min(result, allAcount + allBCount);
        	} else {
        		allAcount++;
        		result = Math.min(result, allAcount + allBCount);
        	}
        }
        return result;
    }
}
