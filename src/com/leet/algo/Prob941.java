package com.leet.algo;

public class Prob941 {
	public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3 || A[0] >= A[1]) return false;
        boolean increase = true;
        for (int i = 1; i < A.length; i++) {
        	if (increase) {
        		if (A[i] < A[i - 1]) increase = false;
        		else if (A[i] == A[i - 1]) return false;
        	} else {
        		if (A[i] == A[i - 1] || A[i] > A[i - 1]) return false;
        	}
        }
        return !increase & true;
    }
}
