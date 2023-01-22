package com.prep2020.medium.more2000;

public class Problem2028 {
	/**
	 * O(m + n)
	 * @param rolls
	 * @param mean
	 * @param n
	 * @return
	 */
	public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, mSum = 0, sum = mean * (m + n);
        for (int r : rolls) mSum += r;
        int rem = sum - mSum;
        if (rem > n * 6 || rem < n * 1) return new int[0];
        int[] result = new int[n];
        int avg = rem / n;
        rem = rem % n;
        for (int i = 0; i < result.length; i++) {
        	result[i] = avg;
        	if (rem > 0) {
        		rem--;
        		result[i]++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2028 problem = new Problem2028();
		System.out.println(problem.missingRolls(new int[]{1, 5, 6}, 3, 4));
	}
}
