package comp.prep2019.less2000;

public class Prob1463 {
	public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(grid, m, n, 0, 0, n - 1, dp);
    }

	private int dfs(int[][] grid, int m, int n, int r, int c1, int c2, 
			Integer[][][] dp) {
		if (r == m) return 0;
		
		if (dp[r][c1][c2] != null) return dp[r][c1][c2];
		int result = 0;
		for (int i = -1; i < 2; i++) {
			int nc1 = c1 + i;
			if (nc1 < 0 || nc1 >= n) continue;
			for (int j = -1; j < 2; j++) {
				int nc2 = c2 + j;
				if (nc2 < 0 || nc2 >= n) continue;
				result = Math.max(result, dfs(grid, m, n, r + 1, nc1, nc2, dp));
			}
		}
		return dp[r][c1][c2] = result + (c1 == c2 ? grid[r][c1] : grid[r][c1] 
				+ grid[r][c2]);
	}
}
