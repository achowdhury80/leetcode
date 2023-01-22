package com.prep2020.medium;

public class Problem1476 {
	private int[][] m;
	public Problem1476(int[][] rectangle) {
        this.m = rectangle;;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
        	for (int j = col1; j <= col2; j++) {
        		m[i][j] = newValue;
        	}
        }
    }
    
    public int getValue(int row, int col) {
        return m[row][col];
    }
}
