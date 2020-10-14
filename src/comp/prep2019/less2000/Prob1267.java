package comp.prep2019.less2000;

public class Prob1267 {
	/**
	 * O(MN)
	 * @param grid
	 * @return
	 */
	public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	int count = 0;
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) count++;
        		if (count > 1) {
        			grid[i][0] += 2;
        			break;
        		}
        	}
        }
        int top = 0;
        for (int j = 0; j < n; j++) {
        	int count = 0;
        	for (int i = 0; i < m; i++) {
        		if (grid[i][j] == 1 || grid[i][j] == 3) count++;
        		if (count > 1) {
        			if (j == 0) top += 2;
        			else grid[0][j] += 2;
        			break;
        		}
        	}
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if((grid[i][j] == 1 || grid[i][j] == 3) && (grid[i][0] > 1 
        				|| (j == 0 ? (top > 1) : (grid[0][j] > 1)))) result++;
        	}
        }
        return result;
    }
}
