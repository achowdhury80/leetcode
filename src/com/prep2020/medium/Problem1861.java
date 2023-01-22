package com.prep2020.medium;

public class Problem1861 {
	/**
	 * O(M * N)
	 * @param box
	 * @return
	 */
	public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
        	char[] rePositioned = findRePositioned(box[i]);
        	for (int j = 0; j < rePositioned.length; j++) {
        		result[j][m - i - 1] = rePositioned[j];
        	}
        }
        return result;
    }

	private char[] findRePositioned(char[] row) {
		int n = row.length;
		char[] rePositioned = new char[n];
		rePositioned[n - 1] = row[n - 1];
		for (int i = n - 2; i > -1; i--) {
			rePositioned[i] = row[i];
			if (row[i] != '#' || rePositioned[i + 1] != '.') continue;
			int j = i;
			while(j < n - 1) {
				if (rePositioned[j + 1] == '.') {
					rePositioned[j + 1] = rePositioned[j];
					rePositioned[j] = '.';
					j++;
				} else break;
			}
			
		}
		return rePositioned;
	}
}
