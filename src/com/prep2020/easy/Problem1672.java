package com.prep2020.easy;

public class Problem1672 {
	/**
	 * O(MN) time
	 * @param accounts
	 * @return
	 */
	public int maximumWealth(int[][] accounts) {
        int result = 0;
        for (int[] accs : accounts) {
        	int sum = 0;
        	for (int acc : accs) sum += acc;
        	result = Math.max(result, sum);
        }
        return result;
    }
}
