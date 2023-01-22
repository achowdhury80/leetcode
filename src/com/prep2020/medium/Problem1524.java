package com.prep2020.medium;

public class Problem1524 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int sum = 0, result = 0, mod = (int)(1e9 + 7);
        for (int i = 0; i < n; i++) {
        	sum += arr[i];
        	dp[i] = i > 0 ? dp[i - 1] : 0;
        	if (sum % 2 == 1) {
        		int numberOfEvens = i + 1 - (i > 0 ? dp[i - 1] : 0);
        		result = (int)((result + 0l + numberOfEvens) % mod);
        		dp[i]++;
        	} else {
        		int numberOfOdds = i > 0 ? dp[i - 1] : 0;
        		result = (int)((result + 0l + numberOfOdds) % mod);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1524 problem = new Problem1524();
		System.out.println(problem.numOfSubarrays(new int[] {2, 4, 6}));
	}
}
