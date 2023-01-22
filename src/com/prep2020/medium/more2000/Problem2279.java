package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2279 {
	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		int n = rocks.length;
        for (int i = 0; i < n; i++) capacity[i] -= rocks[i];
        Arrays.sort(capacity);
        int i = 0, result = 0;
        while(additionalRocks > 0 && i < n) {
        	if (capacity[i] == 0) result++;
        	else {
        		if (capacity[i] > additionalRocks) break;
        		additionalRocks -= capacity[i];
        		result++;
        	}
        	i++;
        }
        return result;
    }
}
