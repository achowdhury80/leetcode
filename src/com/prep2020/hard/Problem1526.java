package com.prep2020.hard;

public class Problem1526 {
	/**
	 * O(N)
	 * @param target
	 * @return
	 */
	public int minNumberOperations(int[] target) {
        int peak = target[0], valley = 0, result = 0;
        boolean ascending = true;
        for (int i = 1; i < target.length; i++) {
        	if (ascending) {
        		if (target[i] >= peak) peak = target[i];
        		else {
        			ascending = false;
        			result += peak - valley;
        			valley = target[i];
        		}
        	} else {
        		if (target[i] <= valley) valley = target[i];
        		else {
        			ascending = true;
        			peak = target[i];
        		}
        	}
        }
        
        if(ascending) result += peak - valley;
        return result;
    }
	
	
}
