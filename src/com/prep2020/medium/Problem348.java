package com.prep2020.medium;

public class Problem348 {
	private char[][] grid;
	private int n;
	public Problem348(int n) {
		this.n = n;
        grid = new char[n][n];
    }
    
    public int move(int row, int col, int player) {
    	char c = player == 1 ? 'x' : 'o';
        grid[row][col] = c;
        boolean same = true;
        for (int i = 0; i < n; i++) {
        	if (grid[row][i] != c) {
        		same = false;
        		break;
        	}
        }
        if (same) return player;
        same = true;
        for (int i = 0; i < n; i++) {
        	if (grid[i][col] != c) {
        		same = false;
        		break;
        	}
        }
        if (same) return player;
        if (row == col || row + col == n - 1) {
        	same = true;
            for (int i = 0; i < n; i++) {
            	if (grid[i][i] != c) {
            		same = false;
            		break;
            	}
            }
            if (same) return player;
            
            same = true;
            for (int i = 0; i < n; i++) {
            	if (grid[i][n - i - 1] != c) {
            		same = false;
            		break;
            	}
            }
            if (same) return player;
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	Problem348 problem = new Problem348(2);
    	System.out.println(problem.move(0, 1, 1));
    	System.out.println(problem.move(1, 1, 2));
    	System.out.println(problem.move(1, 0, 1));
    }
}
