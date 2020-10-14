package comp.prep2019.less2000;
import java.util.*;
public class Prob1260 {
	/**
	 * O(MN)
	 * matrix[i, j] single num position = i * n + j;  n = row length
	 * k %= m * n;
	 * add k to single num position. find % m * n;
	 * find new position
	 * @param grid
	 * @param k
	 * @return
	 */
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		List<List<Integer>> result = new ArrayList<>();
		int m = grid.length, n = grid[0].length;
		k %= (m * n);
		for (int i = 0; i < m; i++) {
			List<Integer> list = new ArrayList<>();
			result.add(list);
			for (int j = 0; j < n; j++) {
				list.add(0);
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int newPosNum = (i * n + j + k) % (m * n);
				int[] newPos = new int[] {newPosNum / n, newPosNum % n};
				result.get(newPos[0]).set(newPos[1], grid[i][j]);
			}
		}
		return result;
    }
}
