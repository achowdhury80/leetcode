package com.prep2020.easy;

public class Problem1716 {
	public int totalMoney(int n) {
        int t = n /7, r = n % 7;
        int result = 7 * t * (t + 1) / 2 + 21 * t;
        int start = t + 1;
        if (r > 0) result += (2 * start + (r - 1)) * r / 2;
        return result;
    }
}
