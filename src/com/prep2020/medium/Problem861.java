package com.prep2020.medium;

public class Problem861 {
	/**
	 * O(m * n)
	 * @param A
	 * @return
	 */
	public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
        	if (A[i][0] == 0) {
        		for (int j = 0; j < n; j++) A[i][j] ^= 1;
        	}
        }
        int result = 0, cur = 1;
        for (int j = n - 1; j > -1; j--) {
        	int oneCount = 0, zeroCount = 0;
        	for (int i = 0; i < m; i++) {
        		if (A[i][j] == 1) oneCount++;
        		else zeroCount++;
        	}
        	result += cur * (Math.max(oneCount, zeroCount));
        	cur <<= 1;
        }
        return result;
    }
}
