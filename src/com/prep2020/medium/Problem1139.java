package com.prep2020.medium;

public class Problem1139 {
	public int largest1BorderedSquare(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        int[][][] arr = new int[m][n][2];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			arr[i][j] = new int[] {1, 1};
        			if (j > 0) arr[i][j][0] += arr[i][j - 1][0];
        			if (i > 0) arr[i][j][1] += arr[i - 1][j][1];
        		}
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			int side = Math.min(arr[i][j][0], arr[i][j][1]);
        			while(side > result) {
        				if (arr[i][j - side + 1][1] >= side && arr[i - side + 1][j][0] >= side) {
        					result = side;
        					break;
        				}
        				side--;
        			}
        		}
        	}
        }
        return result * result;
    }
	
	public static void main(String[] args) {
		Problem1139 problem = new Problem1139();
		System.out.println(problem.largest1BorderedSquare(new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
	}
}
