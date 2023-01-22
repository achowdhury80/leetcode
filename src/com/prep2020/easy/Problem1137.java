package com.prep2020.easy;

public class Problem1137 {
	public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
        	int temp = t0 + t1 + t2;
        	t0 = t1;
        	t1 = t2;
        	t2 = temp;
        }
        return t2;
    }
}
