package com.leet.algo;

public class Prob1137 {
	public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int[] t = new int[]{0, 1, 1};
        for (int i = 3; i <= n; i++) {
        	int temp = t[0] + t[1] + t[2];
        	t[0] = t[1];
        	t[1] = t[2];
        	t[2] = temp;
        }
        return t[2];
    }
}
