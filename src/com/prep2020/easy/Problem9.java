package com.prep2020.easy;

public class Problem9 {
	/**
	 * O(1)
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0, y = x;
        while(y > 0) {
        	int last = y % 10;
        	int temp = rev * 10 + last;
        	if ((temp - last) / 10 != rev) return false;
        	rev = temp;
        	y /= 10;
        }
        return x == rev;
    }
}
