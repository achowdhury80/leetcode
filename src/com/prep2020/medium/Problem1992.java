package com.prep2020.medium;
import java.util.*;
public class Problem1992 {
	/**
	 * O(m * n)
	 * @param land
	 * @return
	 */
	public int[][] findFarmland(int[][] land) {
       int m = land.length, n = land[0].length;
       List<int[]> list = new ArrayList<>();
       for (int i = 0; i < m; i++) {
    	   for (int j = 0; j < n; j++) {
    		   if (land[i][j] == 1) {
    			   int[] pos = new int[] {i, j, i, j};
    			   helper(land, new int[] {i, j}, pos);
    			   list.add(pos);
    		   }
    	   }
       }
       int[][] result = new int[list.size()][];
       for (int i = 0; i < list.size(); i++) {
    	   result[i] = list.get(i);
       }
       return result;
    }

	private void helper(int[][] land, int[] cur, int[] pos) {
		land[cur[0]][cur[1]] = -1;
		if (cur[0] > pos[2] || (cur[0] == pos[2] && cur[1] > pos[3])) {
			pos[2] = cur[0];
			pos[3] = cur[1];
		}
		int[][] dirs = new int[][] {{0, 1}, {1, 0}};
		for (int[] dir : dirs) {
			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (next[0] == land.length || next[1] == land[0].length || land[next[0]][next[1]] < 1) continue;
			helper(land, next, pos);
		}
	}
}
