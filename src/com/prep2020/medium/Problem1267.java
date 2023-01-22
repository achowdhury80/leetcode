package com.prep2020.medium;

public class Problem1267 {
	/**
	 * O(M * N)
	 * @param grid
	 * @return
	 */
	public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int firstRow = 0;
        for (int i = 0; i < m; i++) {
        	int count = 0;
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) count++;
        		if (count > 1) {
        			if (i == 0) firstRow += 2;
        			else grid[i][0] += 2;
        			break;
        		}
        	}
        }
        
        for (int j = 0; j < n; j++) {
        	int count = 0;
        	for (int i = 0; i < m; i++) {
        		if (grid[i][j] == 1 || grid[i][j] == 3) count++;
        		if (count > 1) {
        			grid[0][j] += 2;
        			break;
        		}
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1 || grid[i][j] == 3) {
        			if (grid[0][j] > 1 || (i == 0 ? firstRow == 2 : grid[i][0] > 1)) 
        				result++;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1267 problem = new Problem1267();
		System.out.println(problem.countServers(new int[][] {{1, 0}, {1, 1}}));
	}
}
