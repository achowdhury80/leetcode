package com.prep2020.medium;

public class Problem1936 {
	/**
	 * O(n)
	 * @param rungs
	 * @param dist
	 * @return
	 */
	public int addRungs(int[] rungs, int dist) {
        int cur = 0, result = 0;
        for (int i = 0; i < rungs.length; i++) {
        	if (cur + dist < rungs[i]) {
        		int gap = rungs[i] - cur;
        		int toAdd = (gap - 1) / dist;
        		cur += toAdd * dist;
        		result += toAdd;
        		i--;
        	} else cur = rungs[i];
        }
        return result;
    }
}
