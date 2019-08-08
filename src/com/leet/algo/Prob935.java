package com.leet.algo;

public class Prob935 {
	public int knightDialer(int N) {
		int[][] next = new int[][]{
			{4, 6},
			{6, 8},
			{7, 9},
			{4, 8},
			{0, 3, 9},
			{},
			{0, 1, 7},
			{2, 6},
			{1, 3},
			{2, 4}
		};
		int mod = (int)1e9 + 7;
        int[] dp = new int[10];
        for (int i = 0; i < 10; i++) dp[i] = 1;
        int[] temp = new int[10];
        for (int i = 0; i < N - 1; i++) {
        	for(int j = 0; j < 10; j++) {
        		for (int num : next[j]) {
        			temp[j] = (temp[j] + dp[num]) % mod;
        		}
        	}
        	for (int j = 0; j < 10; j++) {
        		dp[j] = temp[j];
        		temp[j] = 0;
        	}
        }
        
        int result = dp[0];
        for (int i = 1; i < 10; i++) result = (result + dp[i]) % mod;
        
        return result;
    }
}
