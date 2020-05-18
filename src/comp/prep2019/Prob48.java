package comp.prep2019;

public class Prob48 {
	/**
	 * first transpose then swap rows
	 * or rotate
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
	       int n = matrix.length;
	       int i = 0;
	       for (int len = n; len > 1; len -= 2) {
	    	   int temp = -1;
	    	   for (int k = 0; k < len - 1; k++) {
	    		   temp = matrix[i][i + k];
	    		   matrix[i][i + k] = matrix[i + len - k - 1][i];
	    		   matrix[i + len - k - 1][i] = matrix[i + len - 1][i + len - 1 - k];
	    		   matrix[i + len - 1][i + len - 1 - k] = matrix[i + k][i + len - 1];
	    		   matrix[i + k][i + len - 1] = temp;
	    	   }
	           i++;
	       }
	    }
}
