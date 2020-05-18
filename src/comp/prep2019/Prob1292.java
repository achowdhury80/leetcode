package comp.prep2019;

public class Prob1292 {
	public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][][] sum = new int[m][n][2];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		sum[i][j][0] = mat[i][j] + (j > 0 ? sum[i][j - 1][0] : 0);
        		sum[i][j][1] = mat[i][j] + (i > 0 ? sum[i - 1][j][1] : 0);
        	}
        }
        int result = 0;
        int[][][] dp = new int[m][n][Math.min(m, n) + 1];
        for (int k = 1; k <= Math.min(m, n); k++) {
        	for (int i = 0; i < m; i++) {
        		if (i < k - 1) continue;
        		for (int j = 0; j < n; j++) {
        			if (j < k - 1 ) continue;
        			dp[i][j][k] = (i > 0 && j > 0  && k > 1 ? 
        					dp[i - 1][j - 1][k - 1] : 0) 
        					+ sum[i][j][0] - (j - k > -1 ? sum[i][j - k][0] : 0)
        					+ sum[i][j][1] - (i - k > -1 ? sum[i - k][j][1] : 0)
        					- mat[i][j];
        			if (dp[i][j][k] <= threshold) {
        				result = Math.max(result, k);
        			}
        		}
        	}
        	
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1292 prob = new Prob1292();
		int[][] mat = new int[][] {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
		System.out.println(prob.maxSideLength(mat, 4));
	}
}
