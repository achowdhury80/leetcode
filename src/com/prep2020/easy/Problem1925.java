package com.prep2020.easy;

public class Problem1925 {
	/**
	 * O(n^2)
	 * @param n
	 * @return
	 */
	public int countTriples(int n) {
		int result = 0;
        for (int i = 1; i < n; i++) {
        	for (int j = 1; j < n; j++) {
        		if (i == j) continue;
        		int sum = i * i + j * j;
        		int sqrt = (int)Math.sqrt(sum);
        		if (sqrt <= n && sqrt * sqrt == sum) {
        			result++;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1925 problem = new Problem1925();
		System.out.println(problem.countTriples(18));
	}
}
