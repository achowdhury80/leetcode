package com.prep2020.medium;

public class Problem1706 {
	/**
	 * O(m * n)
	 * @param grid
	 * @return
	 */
	public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
        	int[] cur = new int[] {0, i};
        	for (int j = 0; j < m; j++) {
        		if (grid[j][cur[1]] == 1) {
        			if (cur[1] + 1 == n || grid[j][cur[1] + 1] == -1) {
        				result[i] = -1;
        				break;
        			} 
        			cur[0]++;
        			cur[1]++;
        		} else {
        			if (cur[1] - 1 == -1 || grid[j][cur[1] - 1] == 1) {
        				result[i] = -1;
        				break;
        			}
        			cur[0]++;
        			cur[1]--;
        		}
        	}
        	if (result[i] != -1) result[i] = cur[1];
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1706 problem = new Problem1706();
		int[] result = problem.findBall(new int[][] {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},
			{-1,-1,-1,-1,-1}});
		System.out.println(result);
	}
}
