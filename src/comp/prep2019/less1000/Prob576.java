package comp.prep2019.less1000;
public class Prob576 {
	// O(Nmn) O(mn)
	public int findPaths(int m, int n, int N, int i, int j) {
		if(m < 1 || n < 1 || N <= 0) return 0;
		int mod = (int)(1e9 + 7);
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
        int[][] dp = new int[m][n];
        for (int k = 0; k < N; k++) {
        	int[][] temp = new int[m][n];
        	for (int r = 0; r < m; r++) {
        		for (int c = 0; c < n; c++) {
        			for (int[] dir : dirs) {
        	            int x = r + dir[0];
        	            int y = c + dir[1];
        	            if (x < 0 || x == m || y < 0 || y == n) 
        	            	temp[r][c] = (temp[r][c] + 1) % mod;
        	            else temp[r][c] = (temp[r][c] + dp[x][y]) % mod;
        			}
        		}
        	}
        	dp = temp;
        }
        return dp[i][j];
    }
}
