package com.prep2020.medium;

public class Problem1895 {
	public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] sum = new int[m][n][4];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		sum[i][j][0] = (j > 0 ? sum[i][j - 1][0] : 0) + grid[i][j];
        		sum[i][j][1] = (i > 0 ? sum[i - 1][j][1] : 0) + grid[i][j];
        		sum[i][j][2] = ((i > 0 && j > 0) ? sum[i - 1][j - 1][2] : 0) + grid[i][j];
        		sum[i][j][3] = ((i > 0 && j < n - 1) ? sum[i - 1][j + 1][3] : 0) + grid[i][j];
        	}
        }
        int side = Math.min(m, n);
        for (int s = side; s > 1; s--) {
        	for (int i = 0; i + s <= m; i++) {
        		for (int j = 0; j + s <= n; j++) {
        			if (isMagicSquare(i, j, s, sum)) return s;
        		}
        	}
        }
        return 1;
    }

	private boolean isMagicSquare(int row, int col, int side, int[][][] sum) {
		int n = sum[0].length;
		int magicVal = sum[row + side - 1][col + side - 1][2] - ((row > 0 && col > 0) 
				? sum[row - 1][col - 1][2]: 0);
		int secondDiag = sum[row + side - 1][col][3] - ((row > 0 && col + side - 1 < n - 1) 
				? sum[row - 1][col + side][3]: 0);
		if (magicVal != secondDiag) return false;
		for (int i = row; i < row + side; i++) {
			int rowSum = sum[i][col + side - 1][0] - (col > 0 ? sum[i][col - 1][0] : 0);
			if (rowSum != magicVal) return false;
		}
		for (int j = col; j < col + side; j++) {
			int colSum = sum[row + side - 1][j][1] - (row > 0 ? sum[row - 1][j][1] : 0);
			if (colSum != magicVal) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem1895 problem = new Problem1895();
		//System.out.println(problem.largestMagicSquare(new int[][]{{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}}));
		System.out.println(problem.largestMagicSquare(new int[][]{{2, 1, 2},{2, 2, 1},{1, 3, 1}}));
	}
}
