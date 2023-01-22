package com.prep2020.medium;
import java.util.*;
public class Problem576 {
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		if (maxMove == 0) return 0;
        long[][] dp = new long[m][n];
        long mod = (long)(1e9 + 7);
        for (int i = 0; i < m; i++) {
        	dp[i][0] += 1;
        	dp[i][n - 1] += 1;
        }
        
        for (int j = 0; j < n; j++) {
        	dp[0][j] += 1;
        	dp[m - 1][j] += 1;
        }
        
        if (maxMove == 1) return (int)dp[startRow][startColumn];
        
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 2 ; i < maxMove; i++) {
        	long[][] temp = new long[m][n];
        	for (int j = 0; j < m; j++) {
        		for (int k = 0; k < n; k++) {
        			long r = 0l;
        			for (int[] dir : dirs) {
        				int[] next = new int[] {j + dir[0], k + dir[1]};
        				if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) {
        					r = (r + 1) % mod;
        				} else r = (r + dp[next[0]][next[1]]) % mod;
        			}
        			temp[j][k] = r % mod;
        		}
        	}
        	dp = temp;
        }
        long r = 0l;
        for (int[] dir : dirs) {
			int[] next = new int[] {startRow + dir[0], startColumn + dir[1]};
			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) {
				r = (r + 1) % mod;
			} else r = (r + dp[next[0]][next[1]]) % mod;
		}
        
        return (int)r;
    }
}
