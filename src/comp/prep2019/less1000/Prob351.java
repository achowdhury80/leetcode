package comp.prep2019.less1000;

public class Prob351 {
	public int numberOfPatterns(int m, int n) {
		int[][] skip = new int[10][10];
	    skip[1][3] = skip[3][1] = 2;
	    skip[1][7] = skip[7][1] = 4;
	    skip[3][9] = skip[9][3] = 6;
	    skip[7][9] = skip[9][7] = 8;
	    skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] 
	    		= skip[4][6] = skip[6][4] = 5;
	    int result = 0;
	    boolean[] visited = new boolean[10];
	    for (int i = m; i <= n; i++) {
	    	result += dfs(1, skip, visited , i - 1) * 4;
	    	result += dfs(2, skip, visited , i - 1) * 4;
	    	result += dfs(5, skip, visited , i - 1);
	    }
	    return result;
    }
	
	private int dfs(int cur, int[][] skip, boolean[] visited, int remaining) {
		if (remaining < 0) return 0;
		if (remaining == 0) return 1;
		visited[cur] = true;
		int result = 0;
		for (int i = 1; i < 10; i++) {
			if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
				result += dfs(i, skip, visited, remaining - 1);
			}
		}
		visited[cur] = false;
		return result;
	}
}
