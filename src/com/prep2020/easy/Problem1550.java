package com.prep2020.easy;

public class Problem1550 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int a : arr) {
        	if (a % 2 == 0) count = 0;
        	else {
        		count++;
        		if (count == 3) return true;
        	}
        }
        return false;
    }
}
