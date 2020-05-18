package comp.prep2019;

import java.util.Arrays;

public class Prob764 {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
          }
        for (int[] mine : mines) grid[mine[0]][mine[1]] = 0;
        for (int i = 0; i < N; i++) {
        	for (int j = 0, left = 0, up = 0, right = 0, down = 0; j < N; j++) {
        		grid[i][j] = Math.min(grid[i][j], left = (grid[i][j] == 0 ? 0 : left + 1));
        		grid[j][i] = Math.min(grid[j][i], up = (grid[j][i] == 0 ? 0 : up + 1));
        		grid[i][N - 1- j] = Math.min(grid[i][N - 1- j], right = (grid[i][N - 1- j] == 0 ? 0 : right + 1));
        		grid[N - 1- j][i] = Math.min(grid[N - 1- j][i], down = (grid[N - 1- j][i] == 0 ? 0 : down + 1));
        	}
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            result = Math.max(result, grid[i][j]);
          }
        }
        return result;
    }
}
