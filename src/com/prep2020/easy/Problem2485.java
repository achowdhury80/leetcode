package com.prep2020.easy;

public class Problem2485 {
	public int pivotInteger(int n) {
		int sum = (n * ( n + 1)) / 2;
        int r = 0;
        for (int i = n; i > 0; i--) {
        	r += i;
        	if (2 * r == sum + i) return i;
        	if (2 * r > sum + i) return -1;
        }
        return -1;
    }
}
