package com.prep2020.hard;

import java.util.Arrays;

public class Problem1349 {
	public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] dp = new int[1 << n];
        int result = 0;
        for (int i = 0; i < m; i++) {
        	int[] temp = Arrays.copyOf(dp, dp.length);
        	dp = new int[1 << n];
        	for (int j = 0; j < dp.length; j++) {
        		if (!isValid(j, seats[i])) continue;
        		if (i == 0) dp[j] = Math.max(dp[j], findCount(j)); 
        		else {
        			for (int k = 0; k < dp.length; k++) {
        				if (!isValid(k, seats[i - 1])) continue;
        				if (!isAllowed(j, k, n)) continue;
        				dp[j] = Math.max(dp[j], temp[k] + findCount(j));
        			}
        		}
        		if (i == m - 1) result = Math.max(result, dp[j]);
        	}
        	
        }
        
        return result;
    }
    
    private boolean isValid(int j, char[] seatsInARow) {
		int n = seatsInARow.length;
		for (int i = 0; i < n; i++) {
			int cur = (j >> i) & 1;
			if (cur == 1 && seatsInARow[i] == '#') return false;
			if (i > 0 && cur == 1 && ((j >> (i - 1)) & 1) == 1) return false;
		}
		return true;
	}
    
    private boolean isAllowed(int j, int k, int n) {
		for (int i = 0; i < n; i++) {
			int cur = (j >> i) & 1;
			if (cur != 1) continue;
			
			if (i > 0 && ((k >> (i - 1)) & 1) == 1) return false;
			if (i < n - 1 && ((k >> (i + 1)) & 1) == 1) return false;
		}
		return true;
	}
    
    private int findCount(int j) {
		int result = 0;
		while(j > 0) {
			result += (j & 1);
			j >>= 1;
		}
		return result;
	}
}
