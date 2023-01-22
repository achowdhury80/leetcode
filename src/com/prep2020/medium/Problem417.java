package com.prep2020.medium;
import java.util.*;
public class Problem417 {
	/**
	 * O(M * n)
	 * @param heights
	 * @return
	 */
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        Queue<int[]> pac = new LinkedList<>(), ata = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	pacific[i][0] = true;
        	pac.offer(new int[] {i, 0});
        	atlantic[i][n - 1] = true;
        	ata.offer(new int[] {i, n - 1});
        }
        for (int i = 0; i < n; i++) {
        	pacific[0][i] = true;
        	pac.offer(new int[] {0, i});
        	atlantic[m - 1][i] = true;
        	ata.offer(new int[] {m - 1, i});
        }
        populate(heights, pac, pacific);
        populate(heights, ata, atlantic);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (pacific[i][j] && atlantic[i][j]) 
        			result.add(Arrays.asList(i, j));
        	}
        }
        return result;
    }

	private void populate(int[][] heights, Queue<int[]> q, boolean[][] arr) {
		int m = heights.length, n = heights[0].length;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
						|| arr[next[0]][next[1]] 
						|| heights[cur[0]][cur[1]] > heights[next[0]][next[1]])
					continue;
				arr[next[0]][next[1]] = true;
				q.offer(next);
			}
		}
		
	}
}
