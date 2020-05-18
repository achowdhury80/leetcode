package comp.prep2019;
public class Prob750 {
	public int countCornerRectangles(int[][] grid) {
	    int m, n;
	    if ((m = grid.length) < 2 || (n = grid[0].length) < 2) return 0;
	    int result = 0;
	    for (int i = 0; i < m - 1; i++) {
	      for (int j = i + 1; j < m; j++) {
	        int count = 0;
	        for (int k = 0; k < n; k++) {
	          if (grid[i][k] == 1 && grid[j][k] == 1) count++;
	        }
	        if (count > 0) result += count * (count - 1) / 2;
	      }
	    }
	    return result;
	  }
}
