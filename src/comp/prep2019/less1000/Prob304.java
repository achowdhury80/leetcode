package comp.prep2019.less1000;

public class Prob304 {
	private int[][] sum;
	public Prob304(int[][] matrix) {
		if (matrix.length == 0) return;
		int m = matrix.length, n = matrix[0].length;
		this.sum = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i == 0 && j == 0) {
        			sum[i][j] = matrix[i][j];
        			continue;
        		}
        		if (i == 0) {
        			sum[i][j] = matrix[i][j] + sum[i][j - 1];
        		} else if (j == 0) {
        			sum[i][j] = matrix[i][j] + sum[i - 1][j];
        		} else {
        			sum[i][j] = matrix[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
        		}
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = sum[row2][col2];
        if (row1 == 0 && col1 == 0) return result;
        if (row1 == 0) return result - sum[row2][col1 - 1];
        if (col1 == 0) return result - sum[row1 - 1][col2];
        return result - (sum[row2][col1 - 1] + sum[row1 - 1][col2] - sum[row1 - 1][col1 - 1]);
    }
}
