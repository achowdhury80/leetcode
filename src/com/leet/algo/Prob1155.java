package com.leet.algo;

public class Prob1155 {
	public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) return 0;
        int mod = (int)1e9 + 7;
        int[][] dp = new int[d + 1][target + 1];
        for (int i = 1; i <= d; i++) {
        	for (int j = 1; j <= target; j++) {
        		dp[i][j] = -1;
        	}
        }
        return find(d, f, target, dp, mod);
    }
	
	private int find(int d, int f, int target, int[][] dp, int mod) {
		if (dp[d][target] > -1) return dp[d][target];
		if (d == 1) {
			if (target <= f) {
				dp[d][target] = 1;
				return dp[d][target];
			}
			return 0;
		}
		int result = 0;
		for (int i = 1; i <= f; i++) {
			if (i >= target) break; 
			result = (result + find(d - 1, f, target - i, dp, mod)) % mod;
		}
		dp[d][target] = result;
		return result;
	}
	
	public static void main(String[] args) {
		Prob1155 prob = new Prob1155();
		System.out.println(prob.numRollsToTarget(2, 6, 7));
	}
}
