package com.prep2020.medium;
import java.util.*;
public class Problem1462 {
	//Floyd–Warshall Algorithm - Clean code - O(n^3)
		public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, 
				int[][] queries) {
	        boolean[][] connected = new boolean[n][n];
	        for (int[] p : prerequisites)
	            connected[p[0]][p[1]] = true; // p[0] -> p[1]
	        for (int k = 0; k < n; k++) {
	        	for (int i = 0; i < n; i++) {
	        		if (i == k) continue;
	        		for (int j = 0; j < n; j++) {
	        			if (i == j || connected[i][j] || k == i || k == j) continue;
	        			connected[i][j] = connected[i][j] || connected[i][k] 
	        					&& connected[k][j];
	        		}
	        	}
	        }
	        List<Boolean> ans = new ArrayList<>();
	        for (int[] q : queries)
	            ans.add(connected[q[0]][q[1]]);
	        return ans;
	    }
}
