package com.prep2020.easy;

public class Problem1196 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int maxNumberOfApples(int[] arr) {
        int[] counts = new int[1001];
        for (int i : arr) counts[i]++;
        int result = 0, sum = 0;
        for (int i = 1; i < 1001; i++) {
        	while(counts[i] > 0) {
        		counts[i]--;
        		sum += i;
        		if (sum > 5000) break;
        		else result++;
        	}
        	if (sum > 5000) break;
        }
        return result;
    }
}
