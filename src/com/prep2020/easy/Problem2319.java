package com.prep2020.easy;

public class Problem2319 {
	public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if ((i == j || (i + j) == n - 1)) {
        			if (grid[i][j] == 0) return false;
        		}
        		else if (grid[i][j] != 0) return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem2319 problem = new Problem2319();
		System.out.println(problem.checkXMatrix(new int[][]  {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
	}
}
