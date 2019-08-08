package com.leet.algo;

public class Prob994 {
	public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int rotten = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) fresh++;
        		else if(grid[i][j] == 2) rotten++;
        	}
        }
        if (fresh == 0) return 0;
        if (rotten == 0) return -1;
        int result = 0;
        int newRotten = rot(grid);
        while(newRotten > 0) {
        	result++;
        	fresh -= newRotten;
        	newRotten = rot(grid);
        }
        return fresh == 0 ? result: -1;
    }
	
	private int rot(int[][] grid) {
		int rot = 0;
		for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1) {
        			if(i > 0 && grid[i - 1][j] == 2 
        					|| i < grid.length - 1 && grid[i + 1][j] == 2
        					|| j > 0 && grid[i][j - 1] == 2
        					|| j < grid[0].length - 1 && grid[i][j + 1] == 2) {
        				grid[i][j] = -2;
        				rot++;
        			}
        			
        		}
        	}
        }
		for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		grid[i][j] = Math.abs(grid[i][j]);
        	}
        }
		return rot;
	}
	
	
}
