package com.prep2020.easy;

public class Problem263 {
	/**
	 * logN
	 * @param num
	 * @return
	 */
	public boolean isUgly(int num) {
		if (num < 1) return false;
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return num == 1;
    }
}
