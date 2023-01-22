package com.prep2020.medium;

public class Problem2237 {
	public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] arr = new int[n];
        for (int[] light : lights) {
        	int min = Math.max(0, light[0] - light[1]), max = Math.min(n - 1, light[0] + light[1]);
        	arr[min]++;
        	if (max < n - 1) arr[max + 1]--;
        }
    	int result = 0, cur = 0;
    	for (int i = 0; i < n; i++) {
    		cur += arr[i];
    		if (cur >= requirement[i]) result++;
    	}
        return result;
    }
}
