package comp.prep2019;

public class Prob64 {
	/**
	 * O(MN)
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 1; i < n; i++) grid[0][i] += grid[0][i - 1];
		for (int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        	}
        }
        return grid[m - 1][n - 1];
    }
	
	public int minPathSum1(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        for (int i = m - 1; i > -1; i--) {
        	for (int j = n - 1; j > -1; j--) {
        		if(i == m - 1 && j == n - 1) continue;
        		grid[i][j] = grid[i][j] + Math.min(j + 1 < n ? grid[i][j + 1] : Integer.MAX_VALUE, 
        				i + 1 < m ? grid[i + 1][j] : Integer.MAX_VALUE);
        	}
        }
        return grid[0][0];
    }
}
