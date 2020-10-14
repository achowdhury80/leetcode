package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob741 {
	/**
	 * https://leetcode.com/problems/cherry-pickup/solution/
	 * @param grid
	 * @return
	 */
	public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int layer = 0; layer < n; layer++) {
        	for (int row = 0; row < n; row++)
        		Arrays.fill(dp[layer][row], Integer.MIN_VALUE);
        }
        return Math.max(0, func(grid, 0, 0, 0, dp, n));
    }
	
	private int func(int[][] grid, int r1, int c1, int c2, int[][][] dp, int n) {
		int r2 = r1 + c1 -c2;
		if (r1 == n || r2 == n || c1 == n || c2 == n || grid[r1][c1] == -1 
				|| grid[r2][c2] == -1) {
			return -999999;
		}
		if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];
		if (dp[r1][c1][c2] != Integer.MIN_VALUE) return dp[r1][c1][c2];
		int result = grid[r1][c1];
        if (c1 != c2) result += grid[r2][c2];
        result += Math.max(Math.max(func(grid, r1, c1+1, c2+1, dp, n), 
        		func(grid, r1+1, c1, c2+1, dp, n)),
                        Math.max(func(grid, r1, c1+1, c2, dp, n), 
                        		func(grid, r1+1, c1, c2, dp, n)));
        dp[r1][c1][c2] = result;
        return result;
	}
}
