package com.prep2020.easy;

public class Problem66 {
	/**
	 * O(N)
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1; i--) {
        	digits[i]++;
        	if (digits[i] < 10) return digits;
        	digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
