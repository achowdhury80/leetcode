package com.leet.algo;
public class Prob1031 {
	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) sum[i] = sum[i - 1] + A[i];
        return Math.max(helper(A, L, M, sum), helper(A, M, L, sum));
	}
	
	private int helper(int[] A, int L, int M, int[] sum) {
		int[] leftMax = new int[A.length];
		leftMax[L - 1] = sum[L - 1];
		for (int i = L; i < A.length; i++) leftMax[i] = Math.max(leftMax[i - 1], sum[i] - sum[i - L]);
		int[] rightMax = new int[A.length];
		rightMax[A.length - M] = sum[A.length - 1] - sum[A.length - M] + A[A.length - M];
		for (int i = A.length - M - 1; i > 1; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], sum[i + M - 1] - sum[i] + A[i]);
		}
		int result = 0;
		for (int i = L - 1; i < A.length - M; i++) result = Math.max(result, leftMax[i] + rightMax[i + 1]);
		return result;
	}
	/*public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) sum[i] = sum[i - 1] + A[i];
        int result = 0;
        for (int i = 0; i < A.length - L + 1; i++) {
        	int lSum = sum[i + L - 1] - (i > 0 ? sum[i - 1] : 0);
        	int mSum = 0;
        	if (i >= M) {
        		for (int j = M - 1; j < i; j++) {
        			mSum = Math.max(mSum, sum[j] - (j - M + 1 > 0 ? sum[j - M]: 0));
        		}
        	}
        	int j = i + L;
        	while(j + M <= A.length) {
        		mSum = Math.max(mSum, sum[j + M -1] - sum[j - 1]);
        		j++;
        	}
        	result = Math.max(result, lSum + mSum);
        }
        return result;
    }*/
}
