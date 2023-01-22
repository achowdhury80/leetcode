package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2171 {
	public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long sum = 0;
        for (int i : beans) sum += i;
        long result = sum - 1l * n * beans[0];
        for (int i = 1; i < n; i++) {
        	long cur = sum - 1l * (n - i) * beans[i];
        	result = Math.min(result, cur);
        }
        return result;
    }
}
