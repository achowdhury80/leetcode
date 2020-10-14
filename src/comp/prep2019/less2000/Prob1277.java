package comp.prep2019.less2000;

public class Prob1277 {
	public int countSquares(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
        boolean[][][] dp = new boolean[m][n][Math.max(m, n)];
        int result = 0;
        for (int k = 1; k <= Math.max(m, n); k++) {
        	for (int i = 0; i < m; i++) {
        		if (i + k - 1 >= m) break;
        		for (int j = 0; j < n; j++) {
        			if (j + k - 1 >= n) break;
        			if(matrix[i][j] != 1) continue;
        			if (k == 1) {
        				dp[i][j][1] = true;
        				result++;
        			} else {
        				boolean flag = true;
        				if (!dp[i + 1][j + 1][k - 1]) continue;
        				for (int x = 1; x < k; x++) {
        					if (matrix[i + x][j] != 1 || matrix[i][j + x] != 1) {
        						flag = false;
        						break;
        					}
        				}
        				if(flag) {
        					result++;
        					dp[i][j][k] = true;
        				}
        			}
        		}
        	}
        }
        return result;
    }
}
