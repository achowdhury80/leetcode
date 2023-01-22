package com.prep2020.hard;

public class Problem1359 {
	public int countOrders(int n) {
        long last = 1;
        long mod = (long)(1e9 + 7);
        long spaces = 3l;
        for (int i = 2; i <= n; i++) {
        	last = (last * (((spaces * (1l + spaces)) / 2l) % mod)) % mod;
        	spaces += 2;
        }
        return (int)(last % mod);
    }
}
