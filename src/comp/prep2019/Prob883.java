package comp.prep2019;

public class Prob883 {
	/*
	 * o(m^2) m is dimension time and o(1) space
	 * for side shadows, we need to compute row max andcol max
	 * for bottom we need to find the number of occupied spaces
	 * since square grid, we can compute ro_max and col_max at one go
	 * 
	 */
	public int projectionArea(int[][] grid) {
		int m = grid.length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	int row_max = 0, col_max = 0;
        	for (int j = 0; j < m; j++) {
        		if (grid[i][j] != 0) {
        			result++; //bottom shadow
        			row_max = Math.max(row_max, grid[i][j]);
        		}
        		if (grid[j][i] != 0) {
        			col_max = Math.max(col_max, grid[j][i]);
        		}
        	}
        	result += row_max + col_max;
        }
        return result;
    }
}
