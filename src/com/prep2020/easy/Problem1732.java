package com.prep2020.easy;

public class Problem1732 {
	public int largestAltitude(int[] gain) {
        int result = 0, cur = 0;
        for (int g : gain) {
        	cur += g;
        	result = Math.max(result, cur);
        }
        return result;
    }
}
