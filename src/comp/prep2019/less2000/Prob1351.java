package comp.prep2019.less2000;

public class Prob1351 {
	/**
	 * O(m + n) time,
	 * m and n are matrix dimension
	 * @param grid
	 * @return
	 */
	public int countNegatives(int[][] grid) {
		int result = 0;
		int m = grid.length, n= grid[0].length;
		int[] pos = new int[] {0, n - 1};
		while(pos[0] < m && pos[1] > -1) {
			if (grid[pos[0]][pos[1]] < 0) {
				result += (m - pos[0]);
				pos[1]--;
			} else {
				pos[0]++;
			}
		}
		return result;
	}
	public int countNegatives1(int[][] grid) {
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
