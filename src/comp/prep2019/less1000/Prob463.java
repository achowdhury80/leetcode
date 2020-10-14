package comp.prep2019.less1000;

public class Prob463 {
	/**
	 * O(MN)time and O(1) space
	 * @param grid
	 * @return
	 */
	public int islandPerimeter(int[][] grid) {
        int result = 0;
        int m, n;
        if ((m = grid.length) == 0 || (n = grid[0].length) == 0) return result;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			if (i == 0 || grid[i - 1][j] == 0) result++;
        			if (i == m - 1 || grid[i + 1][j] == 0) result++;
        			if (j == 0 || grid[i][j - 1] == 0) result++;
        			if (j == n - 1 || grid[i][j + 1] == 0) result++;
        		}
        	}
        }
        return result;
    }
}
