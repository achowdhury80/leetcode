package com.prep2020.easy;

public class Problem7 {
	/**
	 * O(1)
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
        	int last = x % 10;
        	int temp = rev * 10 + last;
        	if ((temp - last) / 10 != rev) return 0;
        	rev = temp;
        	x /= 10;
        }
        return rev;
    }
}
