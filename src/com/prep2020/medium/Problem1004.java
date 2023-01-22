package com.prep2020.medium;

public class Problem1004 {
	/**
	 * O(N)
	 * @param A
	 * @param K
	 * @return
	 */
	public int longestOnes(int[] A, int K) {
        int start = 0, count = 0, result = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == 0) count++;
        	while (count > K) {
        		if (A[start] == 0) count--;
        		start++;
        	}
        	result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
}
