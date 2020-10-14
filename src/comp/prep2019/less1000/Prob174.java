package comp.prep2019.less1000;
public class Prob174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int m, n;
	    if(dungeon == null || (m = dungeon.length) < 1 
	    		|| (n = dungeon[0].length) < 1) return 0;
	    int[][] dp = new int[m][n];
	    for (int i = m - 1; i > -1; i--) {
	    	for (int j = n - 1; j > -1; j--) {
	    		int rightHealth = getMinHealth(dp, new int[] {i, j}, 
	    				new int[] {i, j + 1}, dungeon);
	    		int downHealth = getMinHealth(dp, new int[] {i, j}, 
	    				new int[] {i + 1, j}, dungeon);
	    		int minHealth = Math.min(rightHealth, downHealth);
	    		if (minHealth == Integer.MAX_VALUE) {
	    			dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
	    		} else {
	    			dp[i][j] = minHealth;
	    		}
	    	}
	    }
	    return dp[0][0];
    }
	
	private int getMinHealth(int[][] dp, int[] cur, int[] next, int[][] dungeon) {
		if (next[0] == dp.length || next[1] == dp[0].length) 
			return Integer.MAX_VALUE;
		return Math.max(1, dp[next[0]][next[1]] - dungeon[cur[0]][cur[1]]);
	}
}
