package com.prep2020.medium;

public class Problem531 {
	/**
	 * O(m * n)
	 * w+1B -> x
	 * b + no B -> y
	 * @param picture
	 * @return
	 */
	public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        for (int i = 0; i < n; i++) {
        	int bCount = 0;
        	for (int j = 0; j < m; j++) {
        		if (picture[j][i] == 'B') {
        			bCount++;
        			if (bCount > 1) break;
        		}
        	}
        	if (bCount == 1) {
        		if (picture[0][i] == 'B') picture[0][i] = 'Y';
        		else picture[0][i] = 'X';
        	}
        }
        char firstRow = 'W';
        for (int i = 0; i < m; i++) {
        	int bCount = 0;
        	for (int j = 0; j < n; j++) {
        		if (picture[i][j] == 'B' || picture[i][j] == 'Y') {
        			bCount++;
        			if (bCount > 1) break;
        		}
        	}
        	if (bCount == 1) {
        		if (i != 0) {
	        		if (picture[i][0] == 'B') picture[i][0] = 'Y';
	        		else picture[i][0] = 'X';
        		} else {
        			if (picture[0][0] == 'B' || picture[0][0] == 'Y') firstRow = 'Y';
	        		else firstRow = 'X';
        		}
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (picture[i][j] == 'B' || picture[i][j] == 'Y') {
        			if (picture[0][j] > 'W') {
        				if (i == 0 && firstRow > 'W' || i > 0 && picture[i][0] > 'W') result++;
        			}
        		}
        	}
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		char[][] pic = new char[][] {{'W','W','B'},{'W','B','W'},{'B','W','W'}};
		Problem531 problem = new Problem531();
		System.out.println(problem.findLonelyPixel(pic));
	}
}
