package com.leet.algo;

public class Prob923 {
	public int threeSumMulti(int[] A, int target) {
		int mod = (int)(1e9 + 7);
        int[] arr = new int[101];
        for (int i = 0; i < A.length; i++) arr[A[i]]++;
        int start = next(arr, 0, A.length - 1, true), end = next(arr, 0, A.length - 1, false);
        while(start + end > target) {
        	end = next(arr, start, end - 1, false);
        }
        int result = 0;
        for (int i = start; i > -1; i = next(arr, i + 1, end, true)) {
        	while (end > -1 && i + end > target) {
        		end = next(arr, i, end - 1, false);
        	}
        	if (end == -1) break;
        	int n;
        	if( start == end && (n = arr[start]) >= 3) {
        		result = (result + n * (n - 1) * (n - 2) / 6) % mod;
        	} else {
        		int other = (target - start - end);
        		if (start == other && arr[start] > 1) {
        			
        		} else if (end == other && arr[end] > 1) {
        			
        		} else {
        			
        		}
        	}
        	
        }
        return result;
    }
	
	private int next(int[] arr, int start, int end, boolean lowest) {
		return 0;
	}
}
