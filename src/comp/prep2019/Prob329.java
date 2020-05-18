package comp.prep2019;
public class Prob329 {
	public int longestIncreasingPath(int[][] matrix) {
		int m, n;
		if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) return 0;
		int[][] path = new int[m][n];
        int result = 1;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		result = Math.max(result, findLongestPath(matrix, path, new int[] {i, j}));
        	}
        }
        return result;
    }
	
	private int findLongestPath(int[][] matrix, int[][] path, int[] pos) {
		if (path[pos[0]][pos[1]] == 0) {
			int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			int count = 0;
			for (int[] dir : dirs) {
				int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
				if (next[0] < 0 || next[0] == matrix.length || next[1] < 0 || next[1] == matrix[0].length) continue;
				if (matrix[pos[0]][pos[1]] >= matrix[next[0]][next[1]]) continue;
				count = Math.max(count, findLongestPath(matrix, path, next));
			}
			path[pos[0]][pos[1]] = count + 1;
		}
		return path[pos[0]][pos[1]];
	}
}
