package com.leet.algo;

public class Prob840 {
	public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        int result = 0;
        for (int i = 0; i < grid.length - 2; i++) {
        	for (int j = 0; j < grid[0].length - 2; j++) {
        		if (isMagicGrid(grid, i, j)) result++;
        	}
        }
        return result;
    }
	
	private boolean isMagicGrid(int[][] grid, int r, int c) {
		if (grid[r + 1][c + 1] != 5) return false;
		int[] check = new int[10];
		int[] rowSum = new int[3];
		int[] colSum = new int[3];
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (grid[i][j] > 9) return false;
				if (++check[grid[i][j]] > 1) return false;
				rowSum[i - r] += grid[i][j];
				colSum[j - c] += grid[i][j];
			}
		}
		if (rowSum[0] != rowSum[1] || rowSum[1] != rowSum[2] || rowSum[2] != colSum[0] || colSum[0] != colSum[1] || colSum[1] != colSum[2] ) return false;
		int diag1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
		int diag2 = grid[r + 2][c] + grid[r + 1][c + 1] + grid[r][c + 2];
		return diag1 == diag2 && diag2 == rowSum[0];
	}
}
