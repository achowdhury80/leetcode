package com.prep2020.medium.more2000;

public class Problem2198 {
	public long singleDivisorTriplet(int[] nums) {
        long[] counts = new long[101];
        for (int i : nums) counts[i]++;
        long result = 0;
        for (int i = 1; i < 101; i++) {
        	if (counts[i] == 0) continue;
        	for (int j = i + 1; j < 100; j++) {
        		if (counts[j] == 0) continue;
        		for (int k = j + 1; k < 101; k++) {
        			int sum = i + j + k;
        			int div = (sum % i == 0 ? 1 : 0) + (sum % j == 0 ? 1 : 0) + (sum % k == 0 ? 1 : 0);
        			if (div == 1) result += 6l * counts[i] * counts[j] * counts[k];
        		}
        	}
        	if (counts[i] > 1) {
        		for (int j = 1; j < 101; j++) {
        			if (j == i) continue;
        			int sum = 2 * i + j;
        			if (sum % i == 0 || sum % j != 0) continue;
        			result += 6l * ((counts[i] * (counts[i] - 1)) / 2) * counts[j];
        		}
        	}
        }
        return result;
    }
}
