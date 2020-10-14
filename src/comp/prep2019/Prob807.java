package comp.prep2019;

public class Prob807 {
	/**
	 * O(M*N) time and O(M + N) space
	 * @param grid
	 * @return
	 */
	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] maxRow = new int[n];
        int[] maxCol = new int[m];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		maxRow[j] = Math.max(maxRow[j], grid[i][j]);
        		maxCol[i] = Math.max(maxCol[i], grid[i][j]);
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		result += Math.min(maxRow[j], maxCol[i]) - grid[i][j];
        	}
        }
        return result;
    }
}
