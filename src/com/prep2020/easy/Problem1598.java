package com.prep2020.easy;

public class Problem1598 {
	/**
	 * O(N)
	 * @param logs
	 * @return
	 */
	public int minOperations(String[] logs) {
        int result = 0;
        for (String log : logs) {
        	if ("../".equalsIgnoreCase(log)) {
        		if (result > 0) result--;
        	}
        	else if ("./".equals(log)) continue;
        	else result++;
        }
        return result;
    }
}
