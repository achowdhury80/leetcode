package com.prep2020.medium;

public class Problem63 {
	/**
	 * O(M*N)
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) 
        	return 0;
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		obstacleGrid[i][j] *= -1;
        	}
        }
        
        for (int i = 0; i < n; i++) {
        	if (obstacleGrid[0][i] == -1) break;
        	obstacleGrid[0][i] = 1;
        }
        
        for (int i = 0; i < m; i++) {
        	if (obstacleGrid[i][0] == -1) break;
        	obstacleGrid[i][0] = 1;
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (obstacleGrid[i][j] == -1) obstacleGrid[i][j] = 0; 
        		else {
        			if (obstacleGrid[i][j - 1] > 0) obstacleGrid[i][j] += obstacleGrid[i][j - 1];
        			if (obstacleGrid[i - 1][j] > 0) obstacleGrid[i][j] += obstacleGrid[i - 1][j];
        		}
        	}
        }
        return obstacleGrid[m - 1][n - 1];
    }
	
	public static void main(String[] args) {
		Problem63 problem = new Problem63();
		System.out.println(problem.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
	}
}
