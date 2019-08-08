package com.leet.algo;

public class Prob896 {
	public boolean isMonotonic(int[] A) {
        if (A == null || A.length < 2) return true;
        Boolean increasing = null;
        for (int i = 1; i < A.length; i++) {
        	int diff = A[i] - A[i - 1];
        	if (diff == 0) continue;
        	if (increasing == null) {
        		increasing = diff > 0;
        	} else if (increasing != (diff > 0)) return false;
        	
        }
        return true;
    }
}
