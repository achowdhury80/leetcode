package comp.prep2019.less1000;

public class Prob48 {
	/**
	 * first transpose then swap rows
	 * or rotate
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
	       int n = matrix.length;
	       for (int i = 1; i < n; i++) {
	    	   for (int j = 0; j < i; j++) {
	    		   int temp = matrix[i][j];
	    		   matrix[i][j] = matrix[j][i];
	    		   matrix[j][i] = temp;
	    	   }
	       }
	       for (int i = 0; i < n; i++) {
	    	   int j = 0, k = n - 1;
	    	   while(j < k) {
	    		   int temp = matrix[i][j];
	    		   matrix[i][j] = matrix[i][k];
	    		   matrix[i][k] = temp;
	    		   j++;
	    		   k--;
	    	   }
	       }
	    }
}
