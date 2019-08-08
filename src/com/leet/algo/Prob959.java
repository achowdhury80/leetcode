package com.leet.algo;

public class Prob959 {
	public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int result = 0;
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
        	arr[i] = grid[i].toCharArray();
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (arr[i][j] == ' ') {
        			result++;
        			captureNeighbors(arr, i, j);
        		}
        	}
        }
        return result;
    }
	
	private void captureNeighbors(char[][] arr, int i, int j) {
		arr[i][j] = 'a';
		if (i > 0 && arr[i - 1][j] == ' ') captureNeighbors(arr, i - 1, j);
		if (i < arr.length - 1 && arr[i + 1][j] == ' ') captureNeighbors(arr, i + 1, j);
		if (j > 0 && arr[i][j - 1] == ' ') captureNeighbors(arr, i, j - 1);
		if (j < arr.length - 1 && arr[i][j + 1] == ' ') captureNeighbors(arr, i, j + 1);
	}
}
