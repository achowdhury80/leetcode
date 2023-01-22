package com.prep2020.easy;

public class Problem2520 {
	public int countDigits(int num) {
        int a = num, result = 0;
        while(a > 0) {
        	int rem = a % 10;
        	if (num % rem == 0) result++;
        	a /= 10;
        }
        return result;
    }
}
