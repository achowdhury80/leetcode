package comp.prep2019;

public class Prob959 {
	/**
	 * https://leetcode.com/problems/regions-cut-by-slashes/discuss/205719/Mark-the-boundary-and-then-the-problem-become-Number-of-Islands-(dfs-or-bfs)
	 * @param grid
	 * @return
	 */
	public int regionsBySlashes(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int[][] g = new int[m * 3][n * 3];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i].charAt(j) == '/') {
        			g[i * 3][j * 3 + 2] = 1;
        			g[i * 3 + 1][j * 3 + 1] = 1;
        			g[i * 3 + 2][j * 3] = 1;
        		} else if (grid[i].charAt(j) == '\\') {
        			g[i * 3][j * 3] = 1;
        			g[i * 3 + 1][j * 3 + 1] = 1;
        			g[i * 3 + 2][j * 3 + 2] = 1;
        		}
        	}
        }
        int result = 0;
        for (int i = 0; i < g.length; i++) {
        	for (int j = 0; j < g[0].length; j++) {
        		if (g[i][j] == 0) {
        			dfs(g, i, j);
        			result++;
        		}
        	}
        }
        return result;
    }
	
	private void dfs(int[][] g, int i, int j) {
		int n = g.length, m = g[0].length;
        if(i < 0 || i >= n || j < 0 || j >= m || g[i][j] == 1) return;
        g[i][j]=1;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs){
            dfs(g, i + dir[0], j + dir[1]);
        }
	}
}
