package com.prep2020.medium.more2000;

public class Problem2052 {
	public int minimumCost(String sentence, int k) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = Integer.MAX_VALUE;
        dp[n - 1] = 0;
        for (int i = n - 2; i > -1; i--) {
        	int curLen = arr[i].length();
        	dp[i] = (k - curLen) * (k - curLen) + dp[i + 1];
        	for (int j = 1; i + j < n; j++) {
        		curLen += 1 + arr[i + j].length();
        		if (curLen > k) break;
        		if (i + j == n - 1) {
        			dp[i] = 0;
        			break;
        		}
        		
        		dp[i] = Math.min(dp[i],  (k - curLen) * (k - curLen) + dp[i + j + 1]);
        	}
        }
        return dp[0];
    }
	
	public static void main(String[] args) {
		Problem2052 problem = new Problem2052();
		System.out.println(problem.minimumCost("i love leetcode", 12));
	}
}
