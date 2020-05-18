package comp.prep2019;
import java.util.*;
public class Prob980 {
	public int uniquePathsIII(int[][] grid) {
        int[] cur = null, result = new int[1];
        int totalCount = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1) cur = new int[] {i, j};
        		else if (grid[i][j] == 0) totalCount++;
        	}
        }
        for (int[] neighbor : findNeighbors(grid, cur)) {
			helper(grid, neighbor, result, 0, totalCount);
		}
        return result[0];
    }
	
	private void helper(int[][] grid, int[] cur, int[] result, int curCount, int totalCount) {
		if (grid[cur[0]][cur[1]] == 2) {
			if (curCount == totalCount) result[0]++;
			return;
		}
		if (grid[cur[0]][cur[1]] == 0) {
			curCount++;
			grid[cur[0]][cur[1]] = 3;
			for (int[] neighbor : findNeighbors(grid, cur)) {
				helper(grid, neighbor, result, curCount, totalCount);
			}
			curCount--;
			grid[cur[0]][cur[1]] = 0;
		} 
	}
	
	private List<int[]> findNeighbors(int[][] grid, int[] cur) {
		List<int[]> result = new ArrayList<>();
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int[] newPos = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (newPos[0] < 0 || newPos[0] >= grid.length 
					|| newPos[1] < 0 || newPos[1] >= grid[0].length) continue;
			result.add(newPos);
		}
		return result;
	}
}
