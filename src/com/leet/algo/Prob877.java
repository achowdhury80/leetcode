package com.leet.algo;

public class Prob877 {
	/**
	 * dp[i][j] stands for alex's count if the region is from ith pile to jth pile
	 * @param piles
	 * @return
	 */
	public boolean stoneGame(int[] piles) {
		int[][] dp = new int[piles.length][piles.length];
		dp[0][0] = piles[0];
		int[] sum = new int[piles.length];
		sum[0] = piles[0];
		for (int i = 1; i < piles.length; i++) {
			dp[i][i] = piles[i];
			sum[i] = piles[i] + sum[i - 1];
		}
        for (int j = 1; j < piles.length; j++) {
        	for(int i = 0; i + j < piles.length; i++) {
        		dp[i][i + j] = Math.max(piles[i] + ((sum[i + j] - sum[i]) - dp[i + 1][i + j]), 
        				piles[i + j] + (sum[i + j - 1] - (i == 0 ? 0 : sum[i - 1]) - dp[i][i + j - 1]));
        	}
        }
        return 2 * dp[0][piles.length - 1] > sum[piles.length - 1];
    }
	public static void main(String[] args) {
		Prob877 prob = new Prob877();
		System.out.println(prob.stoneGame(new int[] {5, 3, 4, 5}));
		
	}
	
}
