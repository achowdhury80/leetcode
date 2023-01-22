package com.prep2020.easy;

public class Problem1491 {
	/**
	 * O(N)
	 * @param salary
	 * @return
	 */
	public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0;
        for (int s : salary) {
        	sum += s;
        	max = Math.max(max, s);
        	min = Math.min(min, s);
        }
        sum -= (max + min);
        return sum / (salary.length - 2);
    }
}
