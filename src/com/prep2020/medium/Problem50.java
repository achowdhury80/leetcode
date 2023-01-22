package com.prep2020.medium;

public class Problem50 {
	public double myPow(double x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		long pow = n;
        if (pow < 0) {
        	x = 1 / x;
        	pow = -pow;
        }
        if (pow % 2 == 0) return myPow(x * x, (int)(pow / 2));
        return x * myPow(x, (int)(pow - 1));
    }
}
