package com.prep2020.medium.more2000;

public class Problem2165 {
	/**
	 * O(n)
	 * @param num
	 * @return
	 */
	public long smallestNumber(long num) {
		int[] count = new int[10];
		int sign = num < 0 ? -1 : 1;
		num = Math.abs(num);
		while(num > 0) {
			count[(int)(num % 10)]++;
			num /= 10;
		}
		long result = 0;
		if (sign == 1) {
			for (int i = 1; i < 10; i++) {
				if (count[i] > 0) {
					result = i;
					count[i]--;
					break;
				}
			}
			for (int i = 0; i < 10; i++) {
				if (count[i] > 0) result = addDigits(result, i, count[i]);
			}
		} else {
			for (int i = 9; i > -1; i--) {
				if (count[i] > 0) result = addDigits(result, i, count[i]);
			}
		}
		return sign * result;
    }

	private long addDigits(long result, int digit, int freq) {
		for (int i = 0; i < freq; i++) result = result * 10 + digit;
		return result;
	}
	
	public static void main(String[] args) {
		Problem2165 problem = new Problem2165();
		System.out.println(problem.smallestNumber(310));
	}
}
