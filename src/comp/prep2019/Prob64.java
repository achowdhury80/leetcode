package comp.prep2019;

public class Prob64 {
	public int minPathSum(int[][] grid) {
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
