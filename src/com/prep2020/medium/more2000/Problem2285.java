package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2285 {
	public long maximumImportance(int n, int[][] roads) {
        int[] arr = new int[n];
        for (int[] r : roads) {
        	arr[r[0]]++;
        	arr[r[1]]++;
        }
        Arrays.sort(arr);
        long result = 0;
        for (int i = n - 1; i > -1; i--) result += (1l * arr[i]) * (i + 1l);
        return result;
    }
}
