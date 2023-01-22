package com.prep2020.easy;

public class Problem896 {
	/**
	 * O(N)
	 * @param A
	 * @return
	 */
	public boolean isMonotonic(int[] A) {
        Boolean increasing = null;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] < A[i - 1]) {
        		if (increasing == null) increasing = false;
        		else if (increasing) return false;
        	} else if (A[i] > A[i - 1]) {
        		if (increasing == null) increasing = true;
        		else if (!increasing) return false;
        	}
        }
        return true;
    }
}
