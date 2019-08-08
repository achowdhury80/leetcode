package com.leet.algo;

public class Prob915 {
	public int partitionDisjoint(int[] A) {
        int leftMax = A[0], globalMax = A[0], boundary = 0;
        for (int i = 1; i < A.length; i++) {
        	globalMax = Math.max(globalMax, A[i]);
        	if (A[i] < leftMax) {
        		boundary = i;
        		leftMax = Math.max(leftMax, globalMax);
        	}
        }
        return boundary + 1;
    }
}
