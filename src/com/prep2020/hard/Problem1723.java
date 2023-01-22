package com.prep2020.hard;

import java.util.Arrays;

public class Problem1723 {
	public int minimumTimeRequired(int[] jobs, int k) {
        int[] buckets = new int[k];
        Arrays.sort(jobs);
        int[] best = new int[] {Integer.MAX_VALUE};
        helper(jobs, 0, buckets, 0, best);
        return best[0];
    }

	private void helper(int[] jobs, int start, int[] buckets, int max, int[] best) {
		if (start == jobs.length) {
			best[0] = Math.min(best[0], max);
			return;
		}
		int[] arr = Arrays.copyOf(buckets, buckets.length);
		Arrays.sort(arr);
		for (int i = 0; i < buckets.length; i++) {
			if (arr[i] + jobs[start] >= best[0]) break;
			if (i > 0 && arr[i] == arr[i - 1]) continue;
			arr[i] += jobs[start];
			helper(jobs, start + 1, arr, Math.max(max, arr[i]), best);
			arr[i] -= jobs[start];
		}
		
	}
	
	
}
