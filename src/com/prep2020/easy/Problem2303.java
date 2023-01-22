package com.prep2020.easy;

public class Problem2303 {
	public double calculateTax(int[][] brackets, int income) {
		double result = 0.;
		int last = 0;
        for (int i = 0; i < brackets.length; i++) {
        	int upperLimit = Math.min(brackets[i][0], income);
        	int taxable = upperLimit - last;
        	last = brackets[i][0];
        	result += (taxable * 1.0 * brackets[i][1]) / 100.;
        	if (income <= brackets[i][0]) break;
        }
        return result;
    }
}
