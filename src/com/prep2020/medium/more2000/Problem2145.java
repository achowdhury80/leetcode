package com.prep2020.medium.more2000;

public class Problem2145 {
	public int numberOfArrays(int[] differences, int lower, int upper) {
        long cur = 0, max = 0, min = 0;
        for (int diff : differences) {
        	long next = diff + cur;
        	min = Math.min(min, next);
        	max = Math.max(max, next);
        	cur = next;
        }
        long gap = max - min + 1, lowerUpperGap = upper - lower +1;
        if (lowerUpperGap < gap) return 0;
        return (int)(1l + lowerUpperGap - gap);
        
    }
}
