package com.prep2020.medium.more2000;

public class Problem2275 {
	public int largestCombination(int[] candidates) {
		int[] count = new int[32];
		int max = 0;
        for (int num : candidates) {
        	for (int i = 0; i < 32; i++) {
        		if ((num & 1) > 0) {
        			count[i]++;
        			max = Math.max(max, count[i]);
        		}
        		num >>= 1;
        		if (num == 0) break;
        	}
        }
        return max;
    }
}
