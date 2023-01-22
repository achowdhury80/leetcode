package com.prep2020.easy;

public class Problem985 {
	/**
	 * O(N)
	 * @param A
	 * @param queries
	 * @return
	 */
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int sum = 0;
        for (int a : A) if (a % 2 == 0) sum += a;
        for (int i = 0; i < queries.length; i++) {
        	int oldVal = A[queries[i][1]];
        	A[queries[i][1]] += queries[i][0];
        	if (oldVal % 2 == 0) sum -= oldVal;
        	if (A[queries[i][1]] % 2 == 0) sum += A[queries[i][1]];
        	result[i] = sum;
        }
        return result;
    }
}
