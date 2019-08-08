package com.leet.algo;

import java.util.Arrays;

public class Prob960 {
	/**
	 * Find the maxCommonSequence length
	 * dp[i] is the max ascending sequence length with ith element as the last element
	 * @param A
	 * @return
	 */
	public int minDeletionSize(String[] A) {
        int[] dp = new int[A[0].length()];
        Arrays.fill(dp, 1);
        int maxAscendingSequence = 0;
        for (int i = 0; i < A[0].length(); i++) {
        	for(int j = 0; j < i; j++) {
        		int k = 0;
        		for (k = 0; k < A.length; k++) {
        			if (A[k].charAt(i) < A[k].charAt(j)) break;
        		}
        		if (k == A.length && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
        		maxAscendingSequence = Math.max(maxAscendingSequence, dp[i]);
        	}
        }
        return A[0].length() - maxAscendingSequence;
    }
	
	public static void main(String[] args) {
		Prob960 prob = new Prob960();
		System.out.println(prob.minDeletionSize(new String[] {"aabbaa","baabab","aaabab"}));
	}
}
