package com.prep2020.medium;

public class Problem1680 {
	public int concatenatedBinary(int n) {
        int mod = (int)(1e9 + 7);
        long result = 0; 
        int length = 0;
        for (int i = 1; i <= n; i++) {
        	if ((i & (i - 1)) == 0) length++;
        	result = ((result << length) | i) % mod;
        }
        return (int)result;
    }
	
	public static void main(String[] args) {
		Problem1680 problem = new Problem1680();
		System.out.println(problem.concatenatedBinary(3));
	}
}
