package com.prep2020.medium;

public class Problem533 {
	public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length, n = picture[0].length;
        int[] blackPixCountForRow = new int[m], blackPixCountForCol = new int[n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (picture[i][j] == 'B') {
        			blackPixCountForRow[i]++;
        			blackPixCountForCol[j]++;
        		}
        	}
        }
        int result = 0;
        for (int j = 0; j < n; j++) {
        	if (blackPixCountForCol[j] != target) continue;
        	int count = 0;
        	String row = "";
        	for (int i = 0; i < m; i++) {
        		if (picture[i][j] == 'B') {
        			if (blackPixCountForRow[i] != target) {
        				count = 0;
        				break;
        			}
        			String curRow = "";
        			for (int k = 0; k < n; k++) curRow += picture[i][k];
        			if (!"".equals(row) && !curRow.equals(row)) {
        				count = 0;
        				break;
        			}
        			count++;
        			row = curRow;
        		}
        	}
        	result += count;
        }
        return result;
    }
}
