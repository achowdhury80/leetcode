package comp.prep2019;

public class Prob1351 {
	public int countNegatives(int[][] grid) {
		int result = 0;
		int n = grid[0].length;
		int j = n - 1;
		for (int i = 0; i < grid.length; i++) {
			for (int k = j; k > -1; k--) {
				if (grid[i][k] >= 0) {
					if (k < j) j = k + 1;
					result += (n - k - 1);
					break;
				}
			}
			if (grid[i][0] < 0) result += n;
		}
		return result;
    }
}
