package comp.prep2019;

public class Prob766 {
	/**
	 * O(m*n)
	 * start from 2nd row(i) and 2nd column(j)
	 * check for each element whether it is equal to matrix[i - 1][j - 1]
	 * @param matrix
	 * @return
	 */
	public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
        	}
        }
        return true;
    }
}
