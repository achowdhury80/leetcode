package comp.prep2019.less1000;

public class Prob73 {
	public void setZeroes(int[][] matrix) {
		int m, n;
		if ((m = matrix.length) < 1 || (n = matrix[0].length) < 1) return;
		boolean row_0 = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					if (i == 0) row_0 = true;
					else matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < m ; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) 
					matrix[i][j] = 0;
			}
		}
		for (int i = 1; i < m && matrix[0][0] == 0; i++) matrix[i][0] = 0;
		for (int i = 0; i < n && row_0; i++) matrix[0][i] = 0;
    }
	
	public static void main(String[] args) {
		//int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		int[][] matrix = new int[][] {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},
			{2147483647,2,-9,-6,-10}};
		
		Prob73 prob = new Prob73();
		prob.setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
