package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1072 {
	/**
	 * O(m^2 * n)
	 *
	 * find out max number of rows which are equal or equivalent
	 * lets say A and B are two matrices
	 * check whether A == B or (A == B') where b' means all the values are flipped
	 * equivalent means flipped value of each column is equal 
	 * @param matrix
	 * @return
	 */
	public int maxEqualRowsAfterFlips(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean[] visitedRow = new boolean[m];
		int result = 1;
		for (int i = 0; i < m; i++) {
			if (visitedRow[i]) continue;
			int count = 1;
			for (int j = i + 1; j < m; j++) {
				if (Arrays.equals(matrix[i], matrix[j])) {
					count++;
					visitedRow[j] = true;
					continue;
				} 
				int[] flip = new int[n];
				for (int k = 0; k < n; k++) {
					flip[k] = 1 - matrix[j][k];
				}
				if (Arrays.equals(matrix[i], flip)) {
					count++;
					visitedRow[j] = true;
					continue;
				} 
			}
			result = Math.max(result, count);
		}
		return result;
	}
}
