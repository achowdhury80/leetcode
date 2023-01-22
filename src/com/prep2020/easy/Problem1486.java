package com.prep2020.easy;

public class Problem1486 {
	public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
        	int num = 2 * i + start;
        	result ^= num;
        }
        return result;
    }
}
