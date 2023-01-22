package com.prep2020.medium;

public class Problem926 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int minFlipsMonoIncr(String s) {
		int n = s.length();
		int oneCount = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1') oneCount++;
		}
        int zeroCount = 0, result = oneCount;
        for (int i = n - 1; i > -1; i--) {
        	if (s.charAt(i) == '0') zeroCount++;
        	else oneCount--;
        	result = Math.min(result, oneCount + zeroCount);
        }
        return result;
    }
}
