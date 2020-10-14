package comp.prep2019.less1000;

public class Prob221 {
	public int maximalSquare(char[][] matrix) {
	    int m, n;
	    if(matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) return 0;
	    int[][] dp = new int[m][n];
	    int result = 0;
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        if (matrix[i][j] == '1') {
	          if (i == 0 || j == 0 || dp[i - 1][j - 1] == 0) dp[i][j] = 1;
	          else {
	            int side = 1;
	            for (int k = 1; k <= dp[i - 1][j - 1]; k++) {
	              if (matrix[i - k][j] != '1' || matrix[i][j - k] != '1') {
	                break;
	              }
	              side++;
	            }
	            dp[i][j] = side;
	          }
	          result = Math.max(result, dp[i][j] * dp[i][j]);
	        }
	      }
	    }
	    return result;
	  }
}
