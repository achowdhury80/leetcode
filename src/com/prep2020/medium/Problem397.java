package com.prep2020.medium;

public class Problem397 {
	/**
	 * O(logN)
	 * @param n
	 * @return
	 */
	public int integerReplacement(int n) {
		return helper(n);
	}
	
	private int helper(long n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return 1 + helper(n >> 1);
        if (n == 3 || (n & 2) == 0 ) return  1 + helper(n - 1);
        return 1 + helper(n + 1);
    }
	
	public static void main(String[] args) {
		Problem397 problem = new Problem397();
		System.out.println(problem.integerReplacement(8));
	}
}
